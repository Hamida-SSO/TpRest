package fr.iocean.model;

import java.util.Objects;

public abstract class GenericModel {
	public abstract int getId();

	public  boolean equals(Object o) {
		if(o==null)return false;
		if(!o.getClass().equals(this.getClass())) return false;
		if(this.getId()>0 && this.getId()==((GenericModel) o).getId()) return true;
		return o==this;
		
	}
	
	public  int hashCode() {
		if(getId()<=0)return super.hashCode();
		return Objects.hashCode(getId());
	}
	
}
