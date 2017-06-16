package com.uele.reidx.android.data.comparator;

import com.uele.reidx.android.data.Deal;

import java.util.Comparator;

public class DealPropertyComparator
        implements Comparator<Deal> {

    @Override
    public int compare(Deal lhs, Deal rhs) {
        return lhs.getTitle().compareTo(rhs.getTitle());
    }
}
