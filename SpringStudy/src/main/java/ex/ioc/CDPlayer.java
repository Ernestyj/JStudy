package ex.ioc;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Jian on 2015/9/28.
 */
@Named
public class CDPlayer implements MediaPlayer{
    private CompactDisc cd;

    @Inject
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    @Override
    public void play() {
        cd.play();
    }
}
