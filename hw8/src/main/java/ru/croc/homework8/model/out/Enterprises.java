package ru.croc.homework8.model.out;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Предприятия.
 */
@XmlRootElement (name = "enterprises")
public class Enterprises {

    /** Список досуговых предприятий. */
    @XmlElementWrapper(name = "leisure_enterprises")
    @XmlElement(name = "l_enterprise")
    private List<Enterprise> lEnterprises;

    /** Список муниципальных предприятий. */
    @XmlElementWrapper(name = "municipal_enterprises")
    @XmlElement(name = "m_enterprise")
    private List<Enterprise> mEnterprises;

    public Enterprises() {
        this.lEnterprises = new ArrayList<>();
        this.mEnterprises = new ArrayList<>();
    }
    public Enterprises(List<Enterprise> lEnterprises, List<Enterprise> mEnterprises) {
        this.lEnterprises = lEnterprises;
        this.mEnterprises = mEnterprises;
    }

        public List<Enterprise> getlEnterprises() {
        return lEnterprises;
    }

    public void setlEnterprises(List<Enterprise> lEnterprises) {
        this.lEnterprises = lEnterprises;
    }

    public List<Enterprise> getmEnterprises() {
        return mEnterprises;
    }

    public void setmEnterprises(List<Enterprise> mEnterprises) {
        this.mEnterprises = mEnterprises;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enterprises that = (Enterprises) o;
        return Objects.equals(lEnterprises, that.lEnterprises) && Objects.equals(mEnterprises, that.mEnterprises);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lEnterprises, mEnterprises);
    }
}
