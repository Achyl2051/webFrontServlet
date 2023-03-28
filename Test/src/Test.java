package etu2051.framework.modele;
import etu2051.framework.servlet.annotations.*;
import etu2051.framework.*;

@ClassAnnotation
public class Test
{
    String input1;
    String input2;

    public Test()
    {}

    public void setInput1(String i1)
    {
        if(i1!="")
        {
            this.input1=i1;
        }
    }

    public void setInput2(String i2)
    {
        if(i2!="")
        {
            this.input2=i2;
        }
    }

    public String getInput1()
    {
        return this.input1;
    }

    public String getInput2()
    {
        return this.input2;
    }

    @UrlAnnotation(url="Test-insert")
    public ModelView insert()
    {
        // manao izay tokony ataony ilay fonction
		ModelView modelview=new ModelView("../result.jsp");
		return modelview;
    }
}