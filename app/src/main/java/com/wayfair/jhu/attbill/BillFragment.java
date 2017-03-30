package com.wayfair.jhu.attbill;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.wayfair.brickkit.BrickFragment;

import java.util.ArrayList;
import java.util.List;

public class BillFragment extends BrickFragment {
    public static final String FRAGMENT_NAME = BillFragment.class.getClass().getName();
    private List<User> userList = new ArrayList<User>(){{
        add(new User("323-491-4157", "静静"));
        add(new User("213-280-4085", "苏钰", 5f));
        add(new User("213-446-8662", "大林"));
        add(new User("213-509-4932", "浩然"));
        add(new User("323-393-5814", "经纬", 26.74f));
        add(new User("323-440-7163", "秋艺"));
        add(new User("323-630-3518", "俊林", 22.77f));
        add(new User("408-687-9615", "晓燕", 0, 2.98f, 2.12f));
        add(new User("925-395-3777", "书琳"));
    }};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
        createBricks();

    }

    private void createBricks() {
        for (int i = 0; i < userList.size(); i++) {
            dataManager.addLast(new BillBrick(getContext(),userList.get(i)));
        }

    }

    public void setSubOverValue(float mainValue, float subvalue) {
        for (int i = 0; i < dataManager.getDataManagerItems().size(); i++) {
            ((BillBrick) dataManager.getDataManagerItems().get(i)).setValue(mainValue, subvalue);
        }
    }

    public void updateData() {
        float sum = 0;
        System.out.println("=========================");
        for (int i = 0; i < dataManager.getDataManagerItems().size(); i++) {
            BillBrick brickBrick = (BillBrick) dataManager.getDataManagerItems().get(i);
            brickBrick.doCaculate();
            dataManager.refreshItem(brickBrick);
            sum += brickBrick.user.total;
            System.out.println("名字:" + String.valueOf(brickBrick.user.name) + " 总费用" + brickBrick.user.total);
        }
        System.out.println("=========================");
        Toast.makeText(getContext(), getString(R.string.saving_info) + " " + String.valueOf(sum), Toast.LENGTH_SHORT).show();
    }
}
