import TinyTestJ.Test;
import TinyTestJ.RunTests;

public class TestSuite {

  // Vector tests
  @Test public static void Vec3DTest1() {
    Vec3D v1 = new Vec3D(1,0,0);
    Vec3D v2 = new Vec3D(3,0,4);
    assert(v1.len() == 1.0);
    assert(v2.len() == 5.0);
  }

  @Test public static void Vec3DTest2() {
    Vec3D v1 = new Vec3D(1,1,0);
    Vec3D v2 = new Vec3D(0,1,0);
    Vec3D v3 = v1.cross(v2);
    assert(v3.x == 0.0);
    assert(v3.y == 0.0);
    assert(v3.z == 1.0);
  }

  // Sphere tests
  @Test public static void SphereTest1() {
    Sphere s = new Sphere( new Vec3D(2,0,0), 1 );
    Entity e = s;
    Vec3D r = e.intersect( new Vec3D(1,0,0) );
    assert(r.x == 1.0);
    assert(r.y == 0.0);
    assert(r.z == 0.0);
  }

  @Test public static void SphereTest2() {
    Sphere s = new Sphere( new Vec3D(2,1,0), 1 );
    Entity e = s;
    Vec3D r = e.intersect( new Vec3D(1,0,0) );
    assert(r.x == 2.0);
    assert(r.y == 0.0);
    assert(r.z == 0.0);
  }

  @Test public static void SphereTest3() {
    Sphere s = new Sphere( new Vec3D(2,2,0), 1 );
    Entity e = s;
    Vec3D r = e.intersect( new Vec3D(1,0,0) );
    assert(r == null);
  }

  // Plane tests
  @Test public static void PlaneTest1() {
    Plane p = new Plane( new Vec3D(2,0,0), new Vec3D(1,0,0) );
    Entity e = p;
    Vec3D r = e.intersect( new Vec3D(1,1,0) );
    assert(r.x == 2.0);
    assert(r.y == 2.0);
    assert(r.z == 0.0);
  }

  @Test public static void PlaneTest2() {
    Plane p = new Plane( new Vec3D(2,0,0), new Vec3D(1,0,0) );
    Entity e = p;
    Vec3D r = e.intersect( new Vec3D(0,1,0) );
    assert(r == null);
  }
 
  // Image tests
  @Test public static void ImageTest1() {
    Image i = new Image(100,100);
    assert (i.data.length == 30000);
  }

  @Test public static void ImageTest2() {
    Image i = new Image(100,100);
    i.set(0,0,0x123456);
    assert (i.data[0] == (byte)0x12);
    assert (i.data[1] == (byte)0x34);
    assert (i.data[2] == (byte)0x56);
    assert (i.data[3] == (byte)0x00);
  }

  @Test public static void ImageTest3() {
    Image i = new Image(100,100);
    i.set(99,99,0x123456);
    int len = i.data.length;
    assert (i.data[len-3] == (byte)0x12);
    assert (i.data[len-2] == (byte)0x34);
    assert (i.data[len-1] == (byte)0x56);
    assert (i.data[len-4] == (byte)0x00);
  }

  @Test public static void ImageTest4() throws java.io.FileNotFoundException,java.io.IOException {
    String filename = "test.ppm";
    Image i = new Image(100,100);
    i.write(filename);
    java.io.File f = new java.io.File(filename);
    boolean exists = f.exists() && f.isFile();
    assert (exists);
  }

}
