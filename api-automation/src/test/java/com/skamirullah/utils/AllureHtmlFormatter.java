package com.skamirullah.utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class AllureHtmlFormatter {

    private static final ObjectMapper mapper =
            new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

    private static String escape(String s) {
        return s == null ? "" :
                s.replace("&", "&amp;")
                 .replace("<", "&lt;")
                 .replace(">", "&gt;");
    }

    public static String requestResponsePanel(
            String uri,
            String method,
            String reqHeaders,
            Object reqBody,
            int status,
            String resHeaders,
            String resBody) {

        String prettyReq;
        try {
            prettyReq = mapper.writeValueAsString(reqBody);
        } catch (Exception e) {
            prettyReq = String.valueOf(reqBody);
        }

        return "<html>\n"
            + "<head>\n"
            + "  <style>\n"
            + "    body {\n"
            + "      margin:0;\n"
            + "      padding:0;\n"
            + "      background:#000;\n"
            + "      font-family: monospace;\n"
            + "      color:#4dff88;\n"
            + "    }\n"
            + "\n"
            + "    .panel {\n"
            + "      padding:18px;\n"
            + "      width:100%;\n"
            + "      box-sizing:border-box;\n"
            + "    }\n"
            + "\n"
            + "    .title {\n"
            + "      color:#ff4d4d;\n"
            + "      font-size:16px;\n"
            + "      font-weight:bold;\n"
            + "      margin-bottom:12px;\n"
            + "    }\n"
            + "\n"
            + "    .key { color:#4da6ff; font-weight:bold; }\n"
            + "\n"
            + "    pre {\n"
            + "      white-space: pre-wrap;\n"
            + "      word-break: break-word;\n"
            + "      margin-top:6px;\n"
            + "    }\n"
            + "\n"
            + "    details {\n"
            + "      margin-top:14px;\n"
            + "    }\n"
            + "\n"
            + "    summary {\n"
            + "      cursor:pointer;\n"
            + "      color:#4da6ff;\n"
            + "      font-weight:bold;\n"
            + "    }\n"
            + "  </style>\n"
            + "</head>\n"
            + "\n"
            + "<body>\n"
            + "  <div class=\"panel\">\n"
            + "\n"
            + "    <div class=\"title\">API Interaction Details</div>\n"
            + "\n"
            + "    <div><span class=\"key\">URI:</span> " + escape(uri) + "</div>\n"
            + "    <div><span class=\"key\">Method:</span> " + escape(method) + "</div>\n"
            + "\n"
            + "    <details open>\n"
            + "      <summary>Request Headers</summary>\n"
            + "      <pre>" + escape(reqHeaders) + "</pre>\n"
            + "    </details>\n"
            + "\n"
            + "    <details open>\n"
            + "      <summary>Request Body</summary>\n"
            + "      <pre>" + escape(prettyReq) + "</pre>\n"
            + "    </details>\n"
            + "\n"
            + "    <div style=\"margin-top:14px;\">\n"
            + "      <span class=\"key\">Status Code:</span> " + status + "\n"
            + "    </div>\n"
            + "\n"
            + "    <details open>\n"
            + "      <summary>Response Headers</summary>\n"
            + "      <pre>" + escape(resHeaders) + "</pre>\n"
            + "    </details>\n"
            + "\n"
            + "    <details open>\n"
            + "      <summary>Response Body</summary>\n"
            + "      <pre>" + escape(resBody) + "</pre>\n"
            + "    </details>\n"
            + "\n"
            + "  </div>\n"
            + "</body>\n"
            + "</html>\n";
    }
}
