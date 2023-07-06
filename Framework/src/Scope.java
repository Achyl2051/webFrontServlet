package etu2051.framework.servlet.annotations;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
@Retention(RetentionPolicy.RUNTIME)
public @interface Scope {
    String valeur();
}
