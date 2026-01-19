package software.ulpgc.kata6.application;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import software.ulpgc.kata6.architecture.io.Store;
import software.ulpgc.kata6.architecture.model.Movie;
import software.ulpgc.kata6.architecture.viewmodel.Histogram;
import software.ulpgc.kata6.architecture.viewmodel.HistogramBuilder;

import javax.swing.*;
import java.util.stream.Stream;

public class Desktop extends JFrame {
    private final Store store;

    private Desktop(Store store){
        this.store = store;
        this.setTitle("Histograma");
        this.setResizable(false);
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
    }

    public static Desktop create(Store store){
        return new Desktop(store);
    }
    public Desktop display(){
        this.getContentPane().add(chartPanerWith(histogram()));
        return this;
    }

    private ChartPanel chartPanerWith(Histogram histogram) {
        return new ChartPanel(chartWith(histogram()));
    }

    private JFreeChart chartWith(Histogram histogram){
        return ChartFactory.createHistogram(
                histogram.title(),
                histogram.x(),
                histogram.y(),
                datasetWith(histogram)
        );
    }

    private XYSeriesCollection datasetWith(Histogram histogram) {
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(seriesIn(histogram));
        return dataset;
    }

    private XYSeries seriesIn(Histogram histogram) {
        XYSeries series = new XYSeries(histogram.legend());
        for(int bin : histogram){
            series.add(bin, histogram.count(bin));

        }
        return series;
    }
    private Histogram histogram() {
        return HistogramBuilder
                .with(movies(store))
                .title("Movies per decade")
                .x("Decade")
                .y("Count")
                .legend("Movies")
                .use(Movie::year);
    }

    private static Stream<Movie> movies(Store store) {
        return store.movies();
    }
}
