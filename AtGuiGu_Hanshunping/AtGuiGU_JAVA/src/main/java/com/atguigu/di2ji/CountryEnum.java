package com.atguigu.di2ji;



public enum  CountryEnum {
    ONE(1,"齐"),TWO(2,"楚"),THREE(3,"燕"),
    FORE(4,"赵"),FIVE(5,"魏"),SIX(6,"韩");

    private Integer retCode;
    private String retMessage;

    public Integer getRetCode() {
        return retCode;
    }

    public String getRetMessage() {
        return retMessage;
    }

    CountryEnum(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }
    public static CountryEnum countryEnum_forearch(int index){
        CountryEnum[] countryEnums = CountryEnum.values();
        for (CountryEnum retCode : countryEnums) {
            if (index==retCode.getRetCode()){
                return retCode;
            }
        }
        return null;
    }
}
