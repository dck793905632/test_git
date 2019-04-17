package com.taotao.rest.jedis;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.HashSet;

public class JedisTest {
  /*  @Test
    public void testJedisSingle(){
        //创建Jedis对象
        Jedis jedis = new Jedis("192.168.25.133",6379);
        //直接调用对象方法,方法名称和redis一致
        jedis.set("key1","aaabbbccc");
        String key1 = jedis.get("key1");
        System.out.println(key1);
        //关闭jedis
        jedis.close();
    }
    @Test
    public void jedisPool(){
        //创建连接池
        JedisPool pool= new JedisPool("192.168.25.133",6379);
        //拿到连接池中的对象
        Jedis jedis = pool.getResource();
        //获取数据
        String key1 = jedis.get("key1");
        System.out.println(key1);
        //关闭对象
        jedis.close();
        //关闭连接池
        pool.close();
    }
    //集群
    @Test
    public void jedisCluster(){
        HashSet<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("192.168.25.133",7001));
        nodes.add(new HostAndPort("192.168.25.133",7002));
        nodes.add(new HostAndPort("192.168.25.133",7003));
        nodes.add(new HostAndPort("192.168.25.133",7004));
        nodes.add(new HostAndPort("192.168.25.133",7005));
        nodes.add(new HostAndPort("192.168.25.133",7006));
        JedisCluster cluster = new JedisCluster(nodes);

        cluster.set("b","1000");
        String a = cluster.get("b");
        System.out.println(a);
        cluster.close();
    }
    //测试spring整合
    @Test
    public void JedisTestSingle(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        JedisPool pool= (JedisPool) applicationContext.getBean("redisClient");
        Jedis jedis = pool.getResource();
        String a = jedis.get("a");
        System.out.println(a);
        jedis.close();
        pool.close();
    }
    //集群版测试
    @Test
    public void JedisTestAll(){
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
        JedisCluster jedisCluster = (JedisCluster) applicationContext.getBean("redisClient");
        String b = jedisCluster.get("b");
        System.out.println(b);
        jedisCluster.close();
    }
*/
}
