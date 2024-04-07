package interfaces;

import java.util.ArrayList;
import java.util.Objects;

public interface CRUD {
    public ArrayList<Object> listar();
    public Object create(Object obj);
    public boolean update(Object obj);
    public boolean delete(Object obj);


}
