package com.itcast.store.web.servlet;

import com.itcast.store.domain.Category;
import com.itcast.store.domain.PageModel;
import com.itcast.store.domain.Product;
import com.itcast.store.service.CategoryService;
import com.itcast.store.service.ProductService;
import com.itcast.store.service.impl.CategoryServiceImpl;
import com.itcast.store.service.impl.ProductServiceImpl;
import com.itcast.store.utils.UUIDUtils;
import com.itcast.store.utils.UploadUtils;
import com.itcast.store.web.base.BaseServlet;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "AdminProductServlet")
public class AdminProductServlet extends BaseServlet {
    //findAllProductsWithPage
    public String findAllProductsWithPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取当前页
        int curNum = Integer.parseInt(request.getParameter("num"));
        //创建service对象
        ProductService productService = new ProductServiceImpl();
        PageModel pageModel = (PageModel) productService.findAllProductsWithPage(curNum);

        //放到request上
        request.setAttribute("page",pageModel);
        //跳转页面
        return "/admin/product/list.jsp";
    }
    //findAllPushDownProWithPage
    public String findAllPushDownProWithPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取当前页
        int curNum=Integer.parseInt(request.getParameter("num"));
        //创建service对象
        ProductService productService = new ProductServiceImpl();
        PageModel pm=productService.findAllPushDownProWithPage(curNum);
        //上传到request
        request.setAttribute("page",pm);
        //页面跳转
        return "/admin/product/pushDown_list.jsp";
    }
    //addProductUI
    public String addProductUI(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取全部分类
        CategoryService categoryService = new CategoryServiceImpl();
        List<Category> list = categoryService.getAllCats();
        //上传到request
        request.setAttribute("allCats",list);
        //跳转页面
        return "/admin/product/add.jsp";
    }
    //addProduct
    public String addProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String ,String > map = new HashMap<String ,String >();
        Product product = new Product();
        try {
            //获取全部信息
            DiskFileItemFactory fac = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(fac);
            List<FileItem> list = upload.parseRequest(request);
            //遍历集合
            for (FileItem item : list) {
                if(item.isFormField()){
                    //如果是 ，普通项
                    //将普通项的name作为键，获取内容作为值放入map中
                    map.put(item.getFieldName(),item.getString("utf-8"));
                }else{
                    //如果是上传项
                    //获取原图片名称
                    String oldFileName = item.getName();
                    //截取后缀并重新起名
                    String newFileName=UploadUtils.getUUIDName(oldFileName);
                    //通过FileItem获取输入流，通过输入流获取图片二进制数据
                    InputStream is = item.getInputStream();
                    //获取到当前项目下的真实路径
                    String realPath=getServletContext().getRealPath("/products/3/");
                    //System.out.println(realPath);
                    //生成随机目录结构的字符串
                    String dir=UploadUtils.getDir(newFileName);
                    String path = realPath+dir;
                    //在内存中声明一个目录
                    File newDir= new File(path);
                    if(!newDir.exists()){
                        newDir.mkdirs();
                    }
                    //在服务器端创建新文件
                    File finalFile = new File(newDir,newFileName);
                    if(!finalFile.exists()){
                        finalFile.createNewFile();
                    }
                    //建立文件输出流
                    OutputStream os = new FileOutputStream(finalFile);
                    //将输入流数据刷到输出流
                    IOUtils.copy(is,os);
                    //释放资源
                    IOUtils.closeQuietly(is);
                    IOUtils.closeQuietly(os);
                    //存入map
                    map.put("pimage","/products/3/"+dir+"/"+newFileName);
                }
            }
            BeanUtils.populate(product,map);
            product.setPid(UUIDUtils.getId());
            product.setPdate(new Date());
            product.setPflag(0);
            //System.out.println(product);
            ProductService productService = new ProductServiceImpl();
            productService.saveProduct(product);
            response.sendRedirect("AdminProductServlet?method=findAllProductsWithPage&num=1");


        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        //
        return null;
    }
    //pushDownProduct
    public String pushDownProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取下架商品pid
        String pid=request.getParameter("pid");
        //修改下架商品pflag=1
        ProductService productService = new ProductServiceImpl();
        productService.updatePflag(pid);
        //重定向页面
        response.sendRedirect("AdminProductServlet?method=findAllProductsWithPage&num=1");
        return  null;
    }
    //pushUpProduct
    public String pushUpProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取下架商品pid
        String pid=request.getParameter("pid");
        //修改下架商品pflag=1
        ProductService productService = new ProductServiceImpl();
        productService.updatePflagUp(pid);
        //重定向页面
        response.sendRedirect("AdminProductServlet?method=findAllPushDownProWithPage&num=1");
        return  null;
    }
    //findUpdateProductByPid
    public String findUpdateProductByPid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取传过来的pid
        String pid =request.getParameter("pid");
        //通过pid查到当前需要修改商品的信息
        ProductService productService = new ProductServiceImpl();
        Product product = productService.findProByPid(pid);
        CategoryService categoryService = new CategoryServiceImpl();
        List<Category> list = categoryService.getAllCats();
        //将商品信息上传到request
        request.setAttribute("p",product);
        request.setAttribute("allCats",list);
        return "/admin/product/edit.jsp";
    }

    //updateProductByPid
    public String updateProductByPid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取需要修改的商品pid
        String pid = request.getParameter("pid");
        //做文件上传准备
        Map<String ,String > map = new HashMap<String ,String >();
        Product product = new Product();
        try {
            //获取全部信息
            DiskFileItemFactory fac = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(fac);
            List<FileItem> list = upload.parseRequest(request);
            //遍历集合
            for (FileItem item : list) {
                if(item.isFormField()){
                    //如果是 ，普通项
                    //将普通项的name作为键，获取内容作为值放入map中
                    map.put(item.getFieldName(),item.getString("utf-8"));
                }else{
                    //获取原图片名称
                    String oldFileName = item.getName();
                    //截取后缀并重新起名
                    String newFileName=UploadUtils.getUUIDName(oldFileName);
                    //通过FileItem获取输入流，通过输入流获取图片二进制数据
                    InputStream is = item.getInputStream();
                    //获取到当前项目下的真实路径
                    String realPath=getServletContext().getRealPath("/products/3/");
                    //System.out.println(realPath);
                    //生成随机目录结构的字符串
                    String dir=UploadUtils.getDir(newFileName);
                    String path = realPath+dir;
                    //在内存中声明一个目录
                    File newDir= new File(path);
                    if(!newDir.exists()){
                        newDir.mkdirs();
                    }
                    //在服务器端创建新文件
                    File finalFile = new File(newDir,newFileName);
                    if(!finalFile.exists()){
                        finalFile.createNewFile();
                    }
                    //建立文件输出流
                    OutputStream os = new FileOutputStream(finalFile);
                    //将输入流数据刷到输出流
                    IOUtils.copy(is,os);
                    //释放资源
                    IOUtils.closeQuietly(is);
                    IOUtils.closeQuietly(os);
                    //存入map
                    map.put("pimage","/products/3/"+dir+"/"+newFileName);
                }
            }
            BeanUtils.populate(product,map);
            ProductService productService = new ProductServiceImpl();
            product.setPid(pid);
            product.setPdate(new Date());
            product.setPflag(0);
            //System.out.println(product);
            productService.updateProductByPid(product);
            //重定向到商品列表页面
            response.sendRedirect("AdminProductServlet?method=findAllProductsWithPage&num=1");
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
        return null;
    }




}
