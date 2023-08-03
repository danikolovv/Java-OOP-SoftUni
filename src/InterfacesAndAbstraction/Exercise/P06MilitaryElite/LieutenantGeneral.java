package InterfacesAndAbstraction.Exercise.P06MilitaryElite;

import java.util.List;

public interface LieutenantGeneral extends Private{

    void addPrivate(Private priv);
    List<Private> getPrivates();
}
