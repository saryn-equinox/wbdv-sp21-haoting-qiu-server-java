package com.example.wbdvsp21haotingqiuserverjava.controllers;

import com.example.wbdvsp21haotingqiuserverjava.models.Widget;
import com.example.wbdvsp21haotingqiuserverjava.services.WidgetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {
  @Autowired
  WidgetService service;

  /**
   * parses Widget JSON object from HTTP body encoded as JSON string.
   * Uses WidgetService to create a new Widget instance and add it to the existing collection of
   * widgets for a topic whose ID is tid. Returns the new widget with a unique identifier
   * @param tid - the topicId from url
   * @param widget - the new widget object
   * @return - the new added widget object
   */
  @PostMapping("/api/topics/{tid}/widgets")
  public Widget createWidget(@PathVariable("tid") String tid,
                             @RequestBody Widget widget) {
    System.out.println(tid);
    service.createWidgetForTopic(tid, widget);
    return widget;
  }

  /**
   * uses WidgetService to retrieve collection of all widgets and returns a string encoded as a JSON array for a topic whose ID is tid
   * @param tid - the topicId
   * @return - list of widgets belong to the given topicId
   */
  @GetMapping("/api/topics/{tid}/widgets")
  public List<Widget> findWidgetsForTopic(@PathVariable("tid") String tid) {
    return service.findWidgetsForTopic(tid);
  }

  /**
   * parses Widget JSON object from HTTP body encoded as JSON string.
   * Uses WidgetService to find widget instance whose id is equal to wid and update the fields
   * to be the new values in widget parameter. Returns 1 if successful, 0 otherwise.
   * @param wid - the widget id
   * @param widget - the new value of widget
   * @return - 1 if update success else 0
   */
  @PutMapping("/api/widgets/{wid}")
  public int updateWidget(@PathVariable("wid") String wid, @RequestBody Widget widget) {
    return service.updateWidget(wid, widget);
  }

  /**
   * uses WidgetService to remove widget whose id is wid. Returns 1 if successful, 0 otherwise.
   * @param wid - the id of the widget that want to delete
   * @return - 1 if success else 0
   */
  @DeleteMapping("/api/widgets/{wid}")
  public int deleteWidget(@PathVariable("wid") String wid) {
    return service.deleteWidget(wid);
  }

  /**
   * uses WidgetService to retrieve collection of all widgets and returns a string encoded as a JSON array.
   * @return - list of widgets
   */
  @GetMapping("/api/widgets")
  public List<Widget> findAllWidgets() {
    return service.findAllWidgets();
  }

  /**
   * uses WidgetService to retrieve a single widget instance whose id is equal to wid and returns a string encoded as a JSON object.
   * @param wid - the widget id
   * @return - the widget object that matches the given widget id
   */
  @GetMapping("/api/widgets/{wid}")
  public Widget findWidgetById(@PathVariable("wid") String wid) {
    return service.findWidgetById(wid);
  }
}
