package etu2051.framework;

public class Mapping {
    String className;
    String method;

    public Mapping(){

    }
    public void setClassName(String value){
        if(value!=""){
            this.className=value;
        }
    }
    public void setMethod(String value){
        if(value!=""){
            this.method=value;
        }
    }
    public String getClassName(){
        return this.className;
    }
    public String getMethod(){
        return this.method;
    }
}