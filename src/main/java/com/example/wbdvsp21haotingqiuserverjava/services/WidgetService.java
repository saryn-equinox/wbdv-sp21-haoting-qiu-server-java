package com.example.wbdvsp21haotingqiuserverjava.services;

import com.example.wbdvsp21haotingqiuserverjava.models.Widget;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WidgetService {
  List<Widget> widgets = new ArrayList<Widget>();
  {
    Widget w1 = new Widget(123l, "ABC123", "HEADING", 1, "Widgets for Topic ABC123");
    Widget w2 = new Widget(234l, "ABC123", "PARAGRAPH", 1, "Lorem Ipsum");
    Widget w3 = new Widget(345l, "ABC234", "HEADING", 2, "Widgets for Topic ABC234");
    Widget w4 = new Widget(456l, "ABC234", "PARAGRAPH", 1, "Lorem Ipsum");
    Widget w5 = new Widget(567l, "ABC234", "PARAGRAPH", 1, "Lorem Ipsum");
    Widget w6 = new Widget(678l, "ABC345", "PARAGRAPH", 1, "Lorem Ipsum");
    Widget w7 = new Widget(789l, "ABC345", "PARAGRAPH", 1, "Lorem Ipsum");
    Widget w8 = new Widget(890l, "ABC345", "PARAGRAPH", 1, "Lorem Ipsum");

    widgets.add(w1);
    widgets.add(w2);
    widgets.add(w3);
    widgets.add(w4);
    widgets.add(w5);
    widgets.add(w6);
    widgets.add(w7);
    widgets.add(w8);
  }

  /**
   * Creates a new Widget instance and add it to the existing collection of widgets for a topic whose ID is
   * tid. Returns new widget with a unique identifier
   * @param topicId - the topicId that this widge belongs to
   * @param widget - new Widget object
   * @return - new widget
   */
  public Widget createWidgetForTopic(String topicId, Widget widget) {
    widget.setTopicId(topicId);
    widget.setId((new Date()).getTime());
    widgets.add(widget);
    return widget;
  }

  /**
   * Returns collection of all widgets for a topic whose ID is tid
   * @param tid - the topicId
   * @return - list of widgets that belong to the topicId
   */
  public List<Widget> findWidgetsForTopic(String tid) {
    List<Widget> widgets = new LinkedList<>();
    for (Widget w : this.widgets)
      if (w.getTopicId().equals(tid)) {
        try {
          widgets.add(w.clone());
        } catch (CloneNotSupportedException e) {
          widgets.add(w);
        }
      }
    return widgets;
  }

  /**
   * Updates widget whose id is wid encoded as JSON in HTTP body. Returns 1 if successful, 0 otherwise
   * @param wid - the id of widget to update
   * @param widget - new widget
   * @return - 1 if successful else 0
   */
  public int updateWidget(String wid, Widget widget) {
    for (int i = 0; i < widgets.size(); i++)
      if (widgets.get(i).getId() == Long.parseLong(wid)) {
        Widget updatedWidget = new Widget(widget);
        updatedWidget.setId(Long.parseLong(wid));
        widgets.set(i, updatedWidget);
        return 1;
      }
    return 0;
  }

  /**
   * Removes widget whose id is wid. Returns 1 if successful, 0 otherwise
   * @param wid - the widget Id to be removed
   * @return - 1 if success else 0
   */
  public int deleteWidget(String wid) {
    for (Widget w : widgets)
      if (w.getId() == Long.parseLong(wid)) {
        widgets.remove(w);
        return 1;
      }
    return 0;
  }

  /**
   * Returns collection of all widgets (optional)
   * @return - list of widgets
   */
  public List<Widget> findAllWidgets() {
    return widgets;
  }

  /**
   * Returns a single widget instance whose id is equal to wid (optional)
   * @return - a widget id equals to the wid
   */
  public Widget findWidgetById(String wid) {
    for (Widget w : widgets)
      if (w.getId() == Long.parseLong(wid))
        return w;
    return null;
  }
}
