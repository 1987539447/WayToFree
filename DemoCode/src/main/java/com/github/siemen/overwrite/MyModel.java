package com.github.siemen.overwrite;


import java.io.*;
import java.util.Arrays;

/**
 * Created by Zhan on 2017/3/7 0007.
 * equals hashCode
 * 浅克隆，深克隆
 */
public class MyModel implements Serializable,Cloneable{
    private short ashort;
    private char achar;
    private byte abyte;
    private boolean abool;
    private long along;
    private float afloat;
    private double adouble;
    private MyModel aObject;
    private int[] ints;
    private MyModel[] models;


    public short getAshort() {
        return ashort;
    }

    public void setAshort(short ashort) {
        this.ashort = ashort;
    }

    public char getAchar() {
        return achar;
    }

    public void setAchar(char achar) {
        this.achar = achar;
    }

    public byte getAbyte() {
        return abyte;
    }

    public void setAbyte(byte abyte) {
        this.abyte = abyte;
    }

    public boolean isAbool() {
        return abool;
    }

    public void setAbool(boolean abool) {
        this.abool = abool;
    }

    public long getAlong() {
        return along;
    }

    public void setAlong(long along) {
        this.along = along;
    }

    public float getAfloat() {
        return afloat;
    }

    public void setAfloat(float afloat) {
        this.afloat = afloat;
    }

    public double getAdouble() {
        return adouble;
    }

    public void setAdouble(double adouble) {
        this.adouble = adouble;
    }

    public MyModel getaObject() {
        return aObject;
    }

    public void setaObject(MyModel aObject) {
        this.aObject = aObject;
    }

    public int[] getInts() {
        return ints;
    }

    public void setInts(int[] ints) {
        this.ints = ints;
    }

    public MyModel[] getModels() {
        return models;
    }

    public void setModels(MyModel[] models) {
        this.models = models;
    }

    /**
     * 检测是否同一对象，==检查
     * 类型检查，instanceof
     * 转换为当前类型，关键区域检查
     * 非double float的原始类型,boolean，==比较
     * double和float使用包装类型compare比较
     * 对象类型递归调用equals
     * 数组类型调用Arrays.equal
     *
     * */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MyModel)) return false;

        MyModel myModel = (MyModel) o;

        if (ashort != myModel.ashort) return false;
        if (achar != myModel.achar) return false;
        if (abyte != myModel.abyte) return false;
        if (abool != myModel.abool) return false;
        if (along != myModel.along) return false;
        if (Float.compare(myModel.afloat, afloat) != 0) return false;
        if (Double.compare(myModel.adouble, adouble) != 0) return false;
        if (aObject != null ? !aObject.equals(myModel.aObject) : myModel.aObject != null) return false;
        if (!Arrays.equals(ints, myModel.ints)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(models, myModel.models);

    }

    /**
     * 取一个非零值（成员）
     * 针对所有关键域（域equals一致）
     * 31*X + 属性域的值
     * 属性域值计算
     * byte char int short ,直接计算int
     * boolean取 ? 1:0
     * float取Float.floatToIntBits
     * double先Double.doubleToLongBits转long,按long类型处理
     * long 计算 (int)long^long>>>32,右移取掩码
     * 对象引用 递归调用hashCode
     * 数组调用Arrays.hashCode
     *
     * 选择31的原因：31为素数，并且被JVM优化为移位操作
     * */

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = (int) ashort;
        result = 31 * result + (int) achar;
        result = 31 * result + (int) abyte;
        result = 31 * result + (abool ? 1 : 0);
        result = 31 * result + (int) (along ^ (along >>> 32));
        result = 31 * result + (afloat != +0.0f ? Float.floatToIntBits(afloat) : 0);
        temp = Double.doubleToLongBits(adouble);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (aObject != null ? aObject.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(ints);
        result = 31 * result + Arrays.hashCode(models);
        return result;
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        //return super.clone();
        return deepClone();
    }

    private Object shallowClone() throws CloneNotSupportedException {
        return super.clone();
    }

    private Object deepClone(){
        Object cloneObj = null;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(baos);
            oos.writeObject(this);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
            cloneObj = ois.readObject();
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return cloneObj;
    }

    @Override
    public String toString() {
        return "MyModel{" +
                "ashort=" + ashort +
                ", achar=" + achar +
                ", abyte=" + abyte +
                ", abool=" + abool +
                ", along=" + along +
                ", afloat=" + afloat +
                ", adouble=" + adouble +
                ", aObject=" + aObject +
                ", ints=" + Arrays.toString(ints) +
                ", models=" + Arrays.toString(models) +
                '}';
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        MyModel m1 = new MyModel();
        m1.setAchar('A');
        m1.setInts(new int[]{1,2,3});
        m1.setAbool(true);
        System.out.println(m1.toString());
        System.out.println(m1.hashCode());
        MyModel m2 = (MyModel) m1.clone();
        System.out.println(m2.toString());
        System.out.println(m2.hashCode());
        m1.setAchar('B');
        m1.getInts()[0]=9;
        System.out.println(m1.toString());
        System.out.println(m2.toString());

    }
}
