package com.uele.reidx.android.data.comparator;

import com.uele.reidx.android.data.Deal;

import java.util.Comparator;

public class DealDateComparator
        implements Comparator<Deal> {

    @Override
    public int compare(Deal lhs, Deal rhs) {
        return lhs.getReleaseDateTheater().compareTo(rhs.getReleaseDateTheater());
    }
}
