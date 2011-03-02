import org.junit.Test;
import sun.misc.Unsafe;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AnnotationTest {

    @SuppressWarnings("")
    @Test
    public void annotationTest() {
       try {
           this.throwSQLExcetion();
       } catch (SQLException sqle) {
           Unsafe.getUnsafe().throwException(sqle);
       }
    }

    @ClassPreamble(author ="Vishal", id=2)
    public void throwSQLExcetion() throws SQLException{
        throw new SQLException("Hello");
    }

    @interface ClassPreamble {
        String author();
        int id();
    }

    class ClassPreambleAPF extends AbstractProcessor {

        @Override
        public boolean process(Set<? extends TypeElement> typeElements, RoundEnvironment roundEnvironment) {

            return false;
        }
    }


}
