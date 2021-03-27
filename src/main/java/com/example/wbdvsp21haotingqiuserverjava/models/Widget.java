package com.example.wbdvsp21haotingqiuserverjava.models;

import javax.persistence.*;

@Entity
@Table(name="widgets")
public class Widget {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id; // Widget's unique identifier

  String name; // Optional name of the widget
  String type; // Type of the widget, e.g., Heading, List, Paragraph, Image, YouTube, HTML, Link
  Long widgetOrder; // Order with respect to widgets in the same list
  String text; // Plain text useful for heading text, paragraph text, link text, etc
  String src; // Absolute or relative URL referring to online resource
  String url; // Absolute or relative URL referring to online resource
  String href; // Absolute or relative URL referring to online resource
  Integer size; // Useful to represent size of widget, e.g., heading size
  Long width; // Widget's horizontal & vertical size, e.g., Image's or YouTube's width & height
  Long height; // Widget's horizontal & vertical size, e.g., Image's or YouTube's width & height
  String cssClass; // CSS class implementing some CSS rule and transformations configured in some CSS rule
  String style; // CSS transformations applied to the widget
  String value; // Some arbitrary initial value interpreted by the widget
  String topicId; // the topicId that this widget belongs to

  public Widget(String name, Long id, String type, Long widgetOrder, String text,
                String src, String url, String href, Integer size, Long width, Long height,
                String cssClass, String style, String value, String topicId) {
    this.name = name;
    this.id = id;
    this.type = type;
    this.widgetOrder = widgetOrder;
    this.text = text;
    this.src = src;
    this.url = url;
    this.href = href;
    this.size = size;
    this.width = width;
    this.height = height;
    this.cssClass = cssClass;
    this.style = style;
    this.value = value;
    this.topicId = topicId;
  }

  public Widget(Long id, String topicId, String type, Integer size, String text) {
    this.id = id;
    this.topicId = topicId;
    this.type = type;
    this.size = size;
    this.text = text;
  }

  public Widget() {
  }

  /**
   * Copy constructor
   * @param o - origin Widget object
   */
  public Widget(Widget o) {
    this.name = o.name;
    this.id = o.id;
    this.type = o.type;
    this.widgetOrder = o.widgetOrder;
    this.text = o.text;
    this.src = o.src;
    this.url = o.url;
    this.href = o.href;
    this.size = o.size;
    this.width = o.width;
    this.height = o.height;
    this.cssClass = o.cssClass;
    this.style = o.style;
    this.value = o.value;
    this.topicId = o.topicId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Long getWidgetOrder() {
    return widgetOrder;
  }

  public void setWidgetOrder(Long widgetOrder) {
    this.widgetOrder = widgetOrder;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public String getSrc() {
    return src;
  }

  public void setSrc(String src) {
    this.src = src;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public Long getWidth() {
    return width;
  }

  public String getTopicId() {
    return topicId;
  }

  public void setTopicId(String topicId) {
    this.topicId = topicId;
  }

  public void setWidth(Long width) {
    this.width = width;
  }

  public Long getHeight() {
    return height;
  }

  public void setHeight(Long height) {
    this.height = height;
  }

  public String getCssClass() {
    return cssClass;
  }

  public void setCssClass(String cssClass) {
    this.cssClass = cssClass;
  }

  public String getStyle() {
    return style;
  }

  public void setStyle(String style) {
    this.style = style;
  }

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
