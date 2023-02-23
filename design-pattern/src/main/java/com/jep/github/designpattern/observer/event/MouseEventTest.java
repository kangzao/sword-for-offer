package com.jep.github.designpattern.observer.event;

import com.jep.github.designpattern.observer.event.mouseevent.Mouse;
import com.jep.github.designpattern.observer.event.mouseevent.MouseEventCallback;
import com.jep.github.designpattern.observer.event.mouseevent.MouseEventType;

public class MouseEventTest {

  public static void main(String[] args) {

    MouseEventCallback callback = new MouseEventCallback();

    Mouse mouse = new Mouse();

    //@谁？  @回调方法
    mouse.addLisenter(MouseEventType.ON_CLICK, callback);
    mouse.addLisenter(MouseEventType.ON_FOCUS, callback);

    mouse.click();

    mouse.focus();


  }
}