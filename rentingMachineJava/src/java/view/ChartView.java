/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author pc
 */
import controller.ReservationController;
import facade.ReservationFacade;
import javax.annotation.PostConstruct;
import java.io.Serializable;
import static java.rmi.server.LogStream.log;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import org.primefaces.model.chart.MeterGaugeChartModel;

@Named("chartView")
@SessionScoped
@ManagedBean
public class ChartView implements Serializable {

    private int total;
    private int occupee;
    private MeterGaugeChartModel meterGaugeModel2;
    private ReservationController rc;

    @PostConstruct
    public void init() {
       rc = new ReservationController();
        this.total = 101;
        System.out.println(this.total);
        this.occupee = this.total - 12;
        createMeterGaugeModels();

    }

    public MeterGaugeChartModel getMeterGaugeModel2() {
        return meterGaugeModel2;
    }

    private MeterGaugeChartModel initMeterGaugeModel() {
        int firstQuart =(int) (total * 0.10);
        int half =  (int) (total * 0.25);
        int thirdQuart =  (int) (total * 0.40);

        List<Number> intervals = new ArrayList<Number>() {
            {
                add(firstQuart);
                add(half);
                add(thirdQuart);
                add(total);
               
            }
        };

        return new MeterGaugeChartModel(occupee, intervals);
    }

    private void createMeterGaugeModels() {

        meterGaugeModel2 = initMeterGaugeModel();
        meterGaugeModel2.setGaugeLabel("Chambres");
        meterGaugeModel2.setSeriesColors("cc6666, E7E658, 93b75f,66cc66");
        meterGaugeModel2.setGaugeLabelPosition("bottom");
        meterGaugeModel2.setShowTickLabels(true);
        meterGaugeModel2.setLabelHeightAdjust(110);
        meterGaugeModel2.setIntervalOuterRadius(100);
        meterGaugeModel2.setMouseoverHighlight(true);

    }

}
