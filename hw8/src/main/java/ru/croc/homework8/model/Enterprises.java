package ru.croc.homework8.model;

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
    @XmlElement (name = "l_enterprise")
    List<LeisureEnterprise> leisureEnterprises;

    /** Список муниципальных предприятий. */
    @XmlElementWrapper(name = "municipal_enterprises")
    @XmlElement (name = "m_enterprise")
    List<MunicipalEnterprise> municipalEnterprises;

    public Enterprises() {
        this.leisureEnterprises = new ArrayList<>();
        this.municipalEnterprises = new ArrayList<>();
    }

    public List<LeisureEnterprise> getLeisureEnterprises() {
        return leisureEnterprises;
    }

    public void setLeisureEnterprises(List<LeisureEnterprise> leisureEnterprises) {
        this.leisureEnterprises = leisureEnterprises;
    }

    public List<MunicipalEnterprise> getMunicipalEnterprises() {
        return municipalEnterprises;
    }

    public void setMunicipalEnterprises(List<MunicipalEnterprise> municipalEnterprises) {
        this.municipalEnterprises = municipalEnterprises;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enterprises that = (Enterprises) o;
        return Objects.equals(leisureEnterprises, that.leisureEnterprises) && Objects.equals(municipalEnterprises, that.municipalEnterprises);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leisureEnterprises, municipalEnterprises);
    }
}
