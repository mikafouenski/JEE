package monapp;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Product implements HttpSessionBindingListener {
    String name;
    String price;
    String desc;
    
    public Product() {
    	System.out.println("création nouveau Produit");
    }
        
    public String getName()            { return name; }
    public String getPrice()           { return price; }
    public String getDesc()            { return desc; }
    public void setName(String name)   { this.name = name; }
    public void setPrice(String price) { this.price = price; }
    public void setDesc(String desc)   { this.desc = desc; }

	@Override
	public void valueBound(HttpSessionBindingEvent arg0) {
		System.out.println("Vie");
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent arg0) {
		System.out.println("Mort");
	} 

}
