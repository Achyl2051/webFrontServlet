package etu2051.framework;
import java.util.HashMap;
import java.util.*;
public class ModelView 
{
    String view;
    HashMap<String,Object> data;

    public ModelView()
    {}

    public ModelView(String view)
    {
        setView(view);
    }

    public ModelView(String view,HashMap<String,Object> data)
    {
        setView(view);
        setData(data);
    }

    public void setView(String value)
    {
        if(value!="")
        {
            this.view=value;
        }
    }

    public String getView()
    {
        return this.view;
    }

    public HashMap<String,Object> getData()
    {
        return data;
    }
    
    public void setData(HashMap<String,Object> d)
    {
        this.data=d;
    }

    public void addItem(String key,Object value)
    {
        data = new HashMap<String, Object>();
        data.put(key,value);
    }
}