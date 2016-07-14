package com.johnarias.sga.domain;

import com.johnarias.sga.domain.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2016-07-11T19:02:04")
@StaticMetamodel(Persona.class)
public class Persona_ { 

    public static volatile SingularAttribute<Persona, String> apeMaterno;
    public static volatile SingularAttribute<Persona, String> telefono;
    public static volatile SetAttribute<Persona, Usuario> usuarios;
    public static volatile SingularAttribute<Persona, String> apePaterno;
    public static volatile SingularAttribute<Persona, String> nombre;
    public static volatile SingularAttribute<Persona, Integer> idPersona;
    public static volatile SingularAttribute<Persona, String> email;

}