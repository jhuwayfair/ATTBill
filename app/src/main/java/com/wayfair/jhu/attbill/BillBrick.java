package com.wayfair.jhu.attbill;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.wayfair.brickkit.BrickViewHolder;
import com.wayfair.brickkit.brick.BaseBrick;


public class BillBrick extends BaseBrick {
    private User user;
    public BillBrick(Context context, User user) {
        super(context, new FullWithBrickSize());
        this.user = user;
    }

    @Override
    public void onBindData(BrickViewHolder brickViewHolder) {
        BillBrickViewHolder viewHolder = (BillBrickViewHolder) brickViewHolder;

        viewHolder.phoneNumber.setText(user.phoneNumber);
        viewHolder.name.setText(user.name);
        viewHolder.planValue.setText(user.name);
        viewHolder.subcharge.setText(user.surchargeFee);
        viewHolder.extraFee.setText(user.extraFee);
        viewHolder.taxes.setText(user.taxes);
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
        public BillBrickViewHolder(View itemView) {
            super(itemView);

            phoneNumber = (TextView) itemView.findViewById(R.id.phoneNumber);
            name = (TextView) itemView.findViewById(R.id.name);
            planValue = (TextView) itemView.findViewById(R.id.planValue);
            extraFee = (EditText) itemView.findViewById(R.id.extraFee);
            subcharge = (EditText) itemView.findViewById(R.id.subcharge);
            taxes = (EditText) itemView.findViewById(R.id.taxes);
        }
    }
}
