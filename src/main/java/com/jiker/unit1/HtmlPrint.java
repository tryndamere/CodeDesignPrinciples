package com.jiker.unit1;

import java.util.List;

public class HtmlPrint extends WeekdayCalendarPrinter {

    public HtmlPrint(String dateStr) {
        super(dateStr);
    }

    @Override
    public void print() {
        StringBuffer html = new StringBuffer();
        html.append("<table>")
                .append(this.buildHead())
                .append(this.buildBody())
                .append("</table>");
        System.out.println(html.toString());
    }

    private String buildHead() {
        StringBuffer html = new StringBuffer();
        html.append("<thead>")
                .append(this.buildRow(this.chineseWeekdayName))
                .append("</thead>");
        return html.toString();
    }

    private String buildBody() {
        StringBuffer html = new StringBuffer();
        html.append("<tbody>")
                .append(this.buildRow(this.weekDays))
                .append("</tbody>");
        return html.toString();
    }

    private String buildRow(List<String> contents) {
        StringBuffer html = new StringBuffer();
        html.append("<tr>");
        for (String content : contents) {
            html.append("<td>")
                    .append(content)
                    .append("</td>");
        }
        html.append("</tr>");
        return html.toString();
    }
}
