package com.databasepreservation.visualization.shared.client.Tools;

import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;

/**
 * @author Bruno Ferreira <bferreira@keep.pt>
 */
public class FontAwesomeIconManager {
  public static final String DATABASES = "server";
  public static final String DATABASE = "database";
  public static final String SCHEMA = "cube";
  public static final String TABLE = "table";
  public static final String RECORD = "file-o";
  public static final String REFERENCE = "exchange";
  public static final String DATABASE_INFORMATION = "info-circle";
  public static final String DATABASE_USERS = "users";
  public static final String DATABASE_SEARCH = "search";
  public static final String SCHEMA_STRUCTURE = "sitemap";
  public static final String SCHEMA_ROUTINES = "cog";
  public static final String SCHEMA_TRIGGERS = "clock-o";
  public static final String SCHEMA_VIEWS = "filter";
  public static final String SCHEMA_DATA = "th-large";
  public static final String SCHEMA_CHECK_CONSTRAINTS = "compress";
  public static final String SCHEMA_TABLE_SEPARATOR = "angle-right";
  public static final String SAVED_SEARCH = "floppy-o";
  public static final String ACTION_EDIT = "pencil";
  public static final String ACTION_DELETE = "trash-o";

  public static String getTag(String icon) {
    return "<i class=\"fa fa-" + icon + "\"></i>";
  }

  public static String getTag(String icon, String tooltip) {
    return "<i class=\"fa fa-" + icon + "\"></i>";
  }

  public static SafeHtml loading(String icon) {
    return SafeHtmlUtils.fromSafeConstant(FontAwesomeIconManager.getTag(icon)
      + " <span class=\"loadingText\">loading...</span>");
  }

  public static SafeHtml loaded(String icon, String text) {
    return SafeHtmlUtils.fromSafeConstant(FontAwesomeIconManager.getTag(icon) + " " + SafeHtmlUtils.htmlEscape(text));
  }
}
