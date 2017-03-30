package com.wayfair.jhu.attbill;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.wayfair.brickkit.BrickViewHolder;
import com.wayfair.brickkit.brick.BaseBrick;

import org.w3c.dom.Text;


public class BillBrick extends BaseBrick {
    public User user;
    private BillBrickViewHolder viewHolder;
    private float subOverValue;
    private float mainOverValue;
    private boolean isBind;
    public BillBrick(Context context, User user) {
        super(context, new FullWithBrickSize());
        this.user = user;
    }

    @Override
    public void onBindData(BrickViewHolder brickViewHolder) {
        isBind = true;
        viewHolder = (BillBrickViewHolder) brickViewHolder;

        viewHolder.phoneNumber.setText(user.phoneNumber);
        viewHolder.name.setText(user.name);
        viewHolder.planValue.setText(String.valueOf(user.planFee));
        viewHolder.subcharge.setText(String.valueOf(user.surchargeFee));
        viewHolder.extraFee.setText(String.valueOf(user.extraFee));
        viewHolder.taxes.setText(String.valueOf(user.taxes));
        viewHolder.total.setText(String.valueOf(user.total));
        viewHolder.mainOver.setChecked(user.isMainOver);
        viewHolder.mainOver.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (!isBind) {
                    user.isMainOver = b;
                }
            }
        });

        viewHolder.subOver.setChecked(user.isSubOver);
        viewHolder.subOver.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (!isBind) {
                    user.isSubOver = b;
                }
            }
        });

        isBind = false;

    }

    public User doCaculate() {
        user.surchargeFee = Float.valueOf(viewHolder.subcharge.getText().toString());
        user.extraFee = Float.valueOf(viewHolder.extraFee.getText().toString());
        user.taxes = Float.valueOf(viewHolder.taxes.getText().toString());
        float mainOver = viewHolder.mainOver.isChecked() ? mainOverValue : 0;
        float sub = viewHolder.subOver.isChecked() ? subOverValue : 0;
        if (viewHolder.subOver.isChecked() && viewHolder.mainOver.isChecked()) {
            Toast.makeText(context, "Two Switches Checked At Same Time", Toast.LENGTH_SHORT).show();
        }

        float total = user.planFee + user.extraFee + user.surchargeFee + user.taxes + mainOver + sub;
        user.total = total;

        viewHolder.total.setText(String.valueOf(total));
        return user;
    }

    public void setValue(float mainOverValue, float subOverValue) {
        this.mainOverValue = mainOverValue;
        this.subOverValue = subOverValue;
    }

    @Override
    public int getLayout() {
        return R.layout.billbrick_layout;
    }

    @Override
    public BrickViewHolder createViewHolder(View view) {
        return new BillBrickViewHolder(view);
    }

    private static final class BillBrickViewHolder extends BrickViewHolder {
        final TextView phoneNumber;
        final TextView name;
        final TextView planValue;
        final EditText extraFee;
        final EditText subcharge;
        final EditText taxes;
        final Switch mainOver;
        final Switch subOver;
        final TextView total;

        public BillBrickViewHolder(View itemView) {
            super(itemView);

            phoneNumber = (TextView) itemView.findViewById(R.id.phoneNumber);
            name = (TextView) itemView.findViewById(R.id.name);
            planValue = (TextView) itemView.findViewById(R.id.planValue);
            extraFee = (EditText) itemView.findViewById(R.id.extraFee);
            subcharge = (EditText) itemView.findViewById(R.id.subcharge);
            taxes = (EditText) itemView.findViewById(R.id.taxes);
            mainOver = (Switch) itemView.findViewById(R.id.mainOver);
            subOver = (Switch) itemView.findViewById(R.id.subOver);
            total = (TextView) itemView.findViewById(R.id.total);
        }

    }
}
