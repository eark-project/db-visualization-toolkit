package com.databasepreservation.visualization.client.common.utils;

import com.databasepreservation.visualization.client.ViewerStructure.ViewerSchema;
import com.databasepreservation.visualization.client.ViewerStructure.ViewerTable;
import com.databasepreservation.visualization.client.ViewerStructure.ViewerView;
import com.databasepreservation.visualization.shared.client.Tools.FontAwesomeIconManager;
import com.databasepreservation.visualization.shared.client.Tools.HistoryManager;
import com.databasepreservation.visualization.shared.client.Tools.ViewerStringUtils;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;

/**
 * @author Bruno Ferreira <bferreira@keep.pt>
 */
public class CommonClientUtils {
  public static void addSchemaInfoToFlowPanel(FlowPanel panel, ViewerSchema schema) {
    panel.add(new HTMLPanel(getFieldHTML("Schema name", schema.getName())));
    if (ViewerStringUtils.isNotBlank(schema.getDescription())) {
      panel.add(new HTMLPanel(getFieldHTML("Schema description", schema.getDescription())));
    }
  }

  public static FlowPanel getSchemaAndTableHeader(String databaseUUID, ViewerTable table, String hClass) {
    FlowPanel panel = new FlowPanel();
    panel.addStyleName("schema-table-header");

    // add icon
    String iconTag = FontAwesomeIconManager.getTag(FontAwesomeIconManager.TABLE);
    HTML html = new HTML(SafeHtmlUtils.fromSafeConstant(iconTag));
    html.addStyleName(hClass);
    panel.add(html);

    // add link schema
    Hyperlink schemaLink = new Hyperlink(table.getSchemaName(), HistoryManager.linkToSchema(databaseUUID,
      table.getSchemaUUID()));
    schemaLink.addStyleName(hClass);
    panel.add(schemaLink);

    // add /
    // Label slashSeparator = new Label("/");
    // slashSeparator.addStyleName(hClass);
    // panel.add(slashSeparator);

    iconTag = FontAwesomeIconManager.getTag(FontAwesomeIconManager.SCHEMA_TABLE_SEPARATOR);
    html = new HTML(SafeHtmlUtils.fromSafeConstant(iconTag));
    html.addStyleName(hClass);
    panel.add(html);

    // add link table
    Hyperlink tableLink = new Hyperlink(table.getName(), HistoryManager.linkToTable(databaseUUID, table.getUUID()));
    tableLink.addStyleName(hClass);
    panel.add(tableLink);

    return panel;
  }

  public static FlowPanel getSavedSearchHeader(String databaseUUID, String savedSearchName) {
    FlowPanel panel = new FlowPanel();
    panel.addStyleName("schema-table-header");
    String hClass = "h1";

    // add icon
    String iconTag = FontAwesomeIconManager.getTag(FontAwesomeIconManager.SAVED_SEARCH);
    HTML html = new HTML(SafeHtmlUtils.fromSafeConstant(iconTag));
    html.addStyleName(hClass);
    panel.add(html);

    // add view name
    Label savedSearchLabel = new Label(savedSearchName);
    savedSearchLabel.addStyleName(hClass);
    panel.add(savedSearchLabel);

    return panel;
  }

  public static FlowPanel getSchemaAndViewHeader(String databaseUUID, ViewerSchema schema, ViewerView view,
    String hClass) {
    FlowPanel panel = new FlowPanel();
    panel.addStyleName("schema-table-header");

    // add icon
    String iconTag = FontAwesomeIconManager.getTag(FontAwesomeIconManager.SCHEMA_VIEWS);
    HTML html = new HTML(SafeHtmlUtils.fromSafeConstant(iconTag));
    html.addStyleName(hClass);
    panel.add(html);

    // add link schema
    Hyperlink schemaLink = new Hyperlink(schema.getName(), HistoryManager.linkToSchema(databaseUUID, schema.getUUID()));
    schemaLink.addStyleName(hClass);
    panel.add(schemaLink);

    iconTag = FontAwesomeIconManager.getTag(FontAwesomeIconManager.SCHEMA_TABLE_SEPARATOR);
    html = new HTML(SafeHtmlUtils.fromSafeConstant(iconTag));
    html.addStyleName(hClass);
    panel.add(html);

    // add view name
    Label viewLink = new Label(view.getName());
    viewLink.addStyleName(hClass);
    panel.add(viewLink);

    return panel;
  }

  public static SafeHtml getFieldHTML(String label, String value) {
    boolean blankLabel = ViewerStringUtils.isBlank(label);
    boolean blankValue = ViewerStringUtils.isBlank(value);

    if (blankLabel || blankValue) {
      return SafeHtmlUtils.EMPTY_SAFE_HTML;

    } else {
      SafeHtmlBuilder b = new SafeHtmlBuilder();
      b.append(SafeHtmlUtils.fromSafeConstant("<div class=\"field\">"));
      b.append(SafeHtmlUtils.fromSafeConstant("<div class=\"label\">"));
      b.append(SafeHtmlUtils.fromString(label));
      b.append(SafeHtmlUtils.fromSafeConstant("</div>"));
      b.append(SafeHtmlUtils.fromSafeConstant("<div class=\"value\">"));
      b.append(SafeHtmlUtils.fromString(value));
      b.append(SafeHtmlUtils.fromSafeConstant("</div>"));
      b.append(SafeHtmlUtils.fromSafeConstant("</div>"));
      return b.toSafeHtml();
    }
  }

  public static SafeHtml getFieldHTML(String label, SafeHtml value) {
    boolean blankLabel = ViewerStringUtils.isBlank(label);
    boolean blankValue = value == null || value == SafeHtmlUtils.EMPTY_SAFE_HTML;

    if (blankLabel || blankValue) {
      return SafeHtmlUtils.EMPTY_SAFE_HTML;

    } else {
      SafeHtmlBuilder b = new SafeHtmlBuilder();
      b.append(SafeHtmlUtils.fromSafeConstant("<div class=\"field\">"));
      b.append(SafeHtmlUtils.fromSafeConstant("<div class=\"label\">"));
      b.append(SafeHtmlUtils.fromString(label));
      b.append(SafeHtmlUtils.fromSafeConstant("</div>"));
      b.append(SafeHtmlUtils.fromSafeConstant("<div class=\"value\">"));
      b.append(value);
      b.append(SafeHtmlUtils.fromSafeConstant("</div>"));
      b.append(SafeHtmlUtils.fromSafeConstant("</div>"));
      return b.toSafeHtml();
    }
  }
}
