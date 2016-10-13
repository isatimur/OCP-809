package com.isatimur.ocp.generics_collections.collections.maps;

public class LoosingMapClass implements Cloneable {
	public int x;
    	public int y;
     
    	public LoosingMapClass(int x1, int y1) {
    		x = x1;
    		y = y1;
    	}
    	
    	@Override
		public int hashCode() {
    		int hash = 11;
    		hash = 23*hash + x;
    		hash = 23*hash + y;
    		return hash;
    	}
    	
    	@Override
		public boolean equals(Object obj) {
    		if (obj == this) 
    			return true;
    		if (obj == null) 
    			return false;
    		if (obj.getClass() != this.getClass()) 
    			return false;
    		LoosingMapClass that = (LoosingMapClass) obj;
    		return (this.x == that.x) && (this.y == that.y);
    	}
    	
    	@Override
		public LoosingMapClass clone() {
    		LoosingMapClass newObj = new LoosingMapClass(this.x, this.y);
    		return newObj;
    	}
     
    }