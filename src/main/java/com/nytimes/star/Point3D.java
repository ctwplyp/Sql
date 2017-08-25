package com.nytimes.star;

import java.math.BigDecimal;

public class Point3D implements Comparable<Point3D> {
		private BigDecimal x,y,z;
	private BigDecimal distance;
	public Point3D (BigDecimal x, BigDecimal y, BigDecimal z) {
		this.setX(x);
		this.setY(y);
		this.setZ(z);
		this.setDistance(x,y,z);
	}
	
	
	public BigDecimal getX() {
		return x;
	}

	public void setX(BigDecimal x) {
		this.x = x;
	}

	public BigDecimal getY() {
		return y;
	}

	public void setY(BigDecimal y) {
		this.y = y;
	}

	public BigDecimal getZ() {
		return z;
	}

	public void setZ(BigDecimal z) {
		this.z = z;
	}


	public BigDecimal getDistance() {
		return distance;
	}


	public void setDistance(BigDecimal x, BigDecimal y, BigDecimal z) {
		ItemProcessor d = new DistanceProcessor();
		this.distance = d.process(x, y, z);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((distance == null) ? 0 : distance.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point3D other = (Point3D) obj;
		if (distance == null) {
			if (other.distance != null)
				return false;
		} else if (!distance.equals(other.distance))
			return false;
		return true;
	}

	@Override
	public int compareTo(Point3D object) {
		// TODO Auto-generated method stub
		if (object instanceof Point3D)
		{
			Point3D point = (Point3D) object;
			return this.getDistance().compareTo(point.getDistance());
		} else
        {
            throw new IllegalArgumentException("obj must be an " +
                " instance of a Point3D object.");
        }
	}


	@Override
	public String toString() {
		return "Point3D [x=" + x + ", y=" + y + ", z=" + z + ", distance=" + distance + "]";
	}



}
