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
        add(new User("323-491-4157", ""));
        add(new User("213-280-4085", ""));
        add(new User("213-446-8662", ""));
        add(new User("213-509-4932", ""));
        add(new User("323-393-5814", ""));
        add(new User("323-440-7163", ""));
        add(new User("323-630-3518", ""));
        add(new User("408-687-9615", ""));
        add(new User("925-395-3777", ""));
    }};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);

    }

    private void createBricks() {

    }

    public void updateData() {
        Toast.makeText(getContext(), getString(R.string.saving_info), Toast.LENGTH_SHORT).show();
    }
}
