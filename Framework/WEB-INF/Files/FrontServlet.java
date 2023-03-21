package etu2051.framework.servlet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.HashMap;
import etu2051.framework.*;
import etu2051.framework.servlet.annotations.*;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FrontServlet extends HttpServlet
{
    HashMap<String,Mapping> mappingUrl = new HashMap<String, Mapping>();
    String pck="";

    public void init() throws ServletException
    {
        ServletContext ctxt=getServletContext();
        this.pck=ctxt.getInitParameter("package");
        try
        {
            loadAnnotation();
        }
        catch(Exception e)
        {}
    }

    public void loadAnnotation()throws Exception
    { 
        List<Class<?>> controllers = Annot.getClassesWithAnnotation3_1(ClassAnnotation.class,this.pck);
        for(Class<?> ca : controllers)
        {
            Method[] controllerMethods = ca.getMethods();
            for(Method method : controllerMethods)
            {
                if(method.isAnnotationPresent(UrlAnnotation.class))
                {
                    Mapping mapping = new Mapping(ca.getName(),method.getName());
                    UrlAnnotation ua = method.getAnnotation(UrlAnnotation.class);
                    String url = ua.url();
                    this.mappingUrl.put(url,mapping);
                }
            }
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
        response.setContentType("text/plain");
	    PrintWriter out = response.getWriter();
        String url=request.getRequestURL().toString();
        String[] url_=url.split("/");
        url="";
        for (int i=5;i<url_.length;i++)
        {
            url+=url_[i];
        }
        String requete=request.getQueryString();
        try
        {
            out.println("la class: "+mappingUrl.get(url).getClassName());
            out.println("la method: "+mappingUrl.get(url).getMethod());
        }
        catch(Exception e)
        {
            out.println("Verifier la liste des urls");
        }
        if (requete!=null)
        {
            url=url+"?"+requete;
        }
        out.println(url);

        out.println("List :");
        out.println("---------------------------------------------------------");
        for(String key : mappingUrl.keySet())
        {
            Mapping value=mappingUrl.get(key);
            out.println("url : "+key);
            out.println("class name : "+value.getClassName());
            out.println("method : "+value.getMethod());
            out.println("---------------------------------------------------------");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}