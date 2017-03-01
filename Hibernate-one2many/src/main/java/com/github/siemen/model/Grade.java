package com.github.siemen.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by 西门 on 2017/2/15 0015.
 */
public class Grade implements Serializable{
    private int gid;
    private String gname;
    private String gdesc;

    private Set<Student> students = new HashSet<Student>();



    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getGdesc() {
        return gdesc;
    }

    public void setGdesc(String gdesc) {
        this.gdesc = gdesc;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Grade grade = (Grade) o;

        if (gid != grade.gid) return false;
        if (gname != null ? !gname.equals(grade.gname) : grade.gname != null) return false;
        if (gdesc != null ? !gdesc.equals(grade.gdesc) : grade.gdesc != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = gid;
        result = 31 * result + (gname != null ? gname.hashCode() : 0);
        result = 31 * result + (gdesc != null ? gdesc.hashCode() : 0);
        return result;
    }

    public Grade(String gname, String gdesc) {
        this.gname = gname;
        this.gdesc = gdesc;
    }

    public Grade() {
    }

    @Override
    public String toString() {
        return "Grade{" +
                "gid=" + gid +
                ", gname='" + gname + '\'' +
                ", gdesc='" + gdesc + '\'' +
                ", students=" + students +
                '}';
    }
}
