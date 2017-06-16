package com.uele.reidx.android.data.time;

public interface Clock {
  long millis();
  long nanos();

  Clock REAL = new Clock() {
    @Override public long millis() {
      return System.currentTimeMillis();
    }

    @Override public long nanos() {
      return System.nanoTime();
    }
  };
}
