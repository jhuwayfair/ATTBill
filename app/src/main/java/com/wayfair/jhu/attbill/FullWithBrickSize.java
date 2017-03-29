package com.wayfair.jhu.attbill;

import com.wayfair.brickkit.size.BrickSize;

/**
 * Created by jhu on 3/29/17.
 */

public class FullWithBrickSize extends BrickSize {
    public static final int maxSpan = 240;
    public FullWithBrickSize() {
        super(maxSpan);
    }

    @Override
    protected int landscapeTablet() {
        return maxSpan;
    }

    @Override
    protected int portraitTablet() {
        return maxSpan;
    }

    @Override
    protected int landscapePhone() {
        return maxSpan;
    }

    @Override
    protected int portraitPhone() {
        return maxSpan;
    }
}
