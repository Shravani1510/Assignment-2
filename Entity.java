

class Entity {
		Vec3D intersect(Vec3D ray) {
			   	return null;
		    }
}

	
		class Sphere extends Entity{
	public	Vec3D	center;
	public	float radius ;

		  Sphere( Vec3D center, float radius) {
			
			this.center = center ;
			 this.radius = radius ;
		}
		@Override
		Vec3D  intersect(Vec3D ray) {

			
			
		float A = center.mul(center);
		float B  = center.mul(ray);
           float  C = radius*radius;

           float discriminent = (B*B- A + C);
           
           if (discriminent >= 0) {
        	   float d = (float )Math.sqrt(discriminent);
            float r= B-d;
            Vec3D point = ray.mul(r);
            
        	   return point;
           }else {
        	   return null;
           }
		
		}
		
		}
		
	class Plane extends Entity{

		public Vec3D p;
		public Vec3D n;
		public Plane(Vec3D p, Vec3D n) {
			this.p = p;
			this.n = n;		
			}
@Override
		 Vec3D intersect(Vec3D ray) {
			 Vec3D s = p.sub(ray);
			 float s1 = ray.mul(n);
			 float t = s.mul(n)/s1;
     Vec3D point = (ray.mul(t)).add(ray);
     if(s1 == 0) {
    	 return null;
     }else {
    	 return point;
     }
		 }
	}
