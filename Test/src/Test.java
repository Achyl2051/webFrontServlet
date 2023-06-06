package etu2051.framework.modele;
import etu2051.framework.servlet.annotations.*;
import etu2051.framework.*;
import java.util.*;

@ClassAnnotation
public class Test
{
    String input1;
    String input2;

    public Test()
    {}

    public Test(String input1,String input2)
    {
        setInput1(input1);
        setInput2(input2);
    }

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

        ArrayList<Test> listTest=new ArrayList<Test>();
        Test a=new Test("url 1","Tahiry");
        Test b=new Test("url 2","Johary");
        listTest.add(a);
        listTest.add(b);
		
        ModelView modelview=new ModelView("../result.jsp");
        modelview.addItem("listTest",listTest);
		return modelview;
    }

    @UrlAnnotation(url="Test-save")
	public void save(){
		System.out.println("input1: "+this.getInput1());
		System.out.println("input2: "+this.getInput2());
	}

    @UrlAnnot(url="Test-print")
	public void print(String soratra){
		System.out.println(soratra);
	}
}