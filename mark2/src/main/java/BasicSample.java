import com.vladsch.flexmark.util.ast.Node;
import com.vladsch.flexmark.html.HtmlRenderer;
import com.vladsch.flexmark.parser.Parser;
import com.vladsch.flexmark.util.data.MutableDataSet;

import java.io.*;

/**
 * @author LongNight
 * @version V1.0
 * @Project mark2
 * @Package PACKAGE_NAME
 * @Description:
 * @Date 2022/8/30 19:30
 */


public class BasicSample {
    public static void main(String[] args) {
        MutableDataSet options = new MutableDataSet();

        // uncomment to set optional extensions
        //options.set(Parser.EXTENSIONS, Arrays.asList(TablesExtension.create(), StrikethroughExtension.create()));

        // uncomment to convert soft-breaks to hard breaks
        //options.set(HtmlRenderer.SOFT_BREAK, "<br />\n");

        Parser parser = Parser.builder(options).build();
        HtmlRenderer renderer = HtmlRenderer.builder(options).build();

        // You can re-use parser and renderer instances
        Node document = null;
        try {
            document = parser.parseReader(new FileReader(new File("src/main/webapp/集合.md")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileWriter fileWriter=null;
        try {
            fileWriter=new FileWriter(new File("src/main/webapp/集合.html"));
            String html = renderer.render(document);  // "<p>This is <em>Sparta</em></p>\n"
            fileWriter.write(html);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
