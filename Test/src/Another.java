package etu2051.framework.modele;
import etu2051.framework.servlet.annotations.*;
import etu2051.framework.*;

@ClassAnnotation
public class Another
{
    String input1;
    String input2;

    public Another()
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

    @UrlAnnotation(url="Another-select")
    public ModelView select()
    {
        // manao izay tokony ataony ilay fonction
		ModelView modelview=new ModelView("../result.jsp");
		return modelview;
    }

    @UrlAnnotation(url="Another-save")
	public void save(){
		System.out.println("input1: "+this.getInput1());
		System.out.println("input2: "+this.getInput2());
	}

    @UrlAnnot(url="Another-print")
	public void print(String soratra){
		System.out.println(soratra);
	}
}