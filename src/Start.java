import java.util.*;

public class Start
{
    private final static double G = 6.67408 * 10E-11;


    public static void main(String[] args){

        Ship ship = new Ship();


        double anglV = 0;//0~1
        double anglH;//NAN or 0~360

        double aH = 0;
        double aV = 0;
        double distance = 0;
        double horSpeed = 0;
        double vertSpeed = 0;

        double r = 6.378 * 10E6;
        double m = 5.976 * 10E24;

        ship.setMass(10000);//kg
        ship.setFuelMass(8000);//kg
        ship.setFuelOut(100);//kg
        ship.setPowerTrust(200000);//N
        ship.setHeights(r); //m

        double fuelOut = ship.getFuelOut() / 1000;

        int i = 0;
        int a = 0;

        while(true){

            if(true){

                if(ship.getFuelMass() > 0){

                    ship.setFuelMass(ship.getFuelMass() - fuelOut);
                    ship.setMass(ship.getMass() - fuelOut);

                    ship.setAccel((ship.getPowerTrust() / ship.getMass()) - getAccelerationOfGravity(m, ship.getHeights()));
                    ship.setSpeed(ship.getSpeed() + (ship.getAccel() / 1000));

                    aH = ship.getAccel() * anglV;
                    aV = ship.getAccel() - aH;

                    horSpeed = horSpeed + (aH / 1000);
                    vertSpeed = vertSpeed + ( aV / 1000);

                    ship.setHeights(ship.getHeights() + (aV / 1000));

                    distance = distance + (aH / 1000);
                    i++;
                }
                else{

                    ship.setAccel(-getAccelerationOfGravity(m, ship.getHeights()));
                    ship.setSpeed(ship.getSpeed() + (ship.getAccel() / 1000));

                    vertSpeed = vertSpeed + (ship.getAccel() / 1000);
                    ship.setHeights(ship.getHeights() + (vertSpeed / 1000));

                    distance = distance + horSpeed;
                    i++;
                }
            }

            if(i == 1000){

                System.out.println("время:         " + a);
                System.out.println("масса:         " + ship.getMass());
                System.out.println("ускорение:     " + ship.getAccel());
                System.out.println("скорость:      " + ship.getSpeed());
                System.out.println("верт скорость: " + vertSpeed);
                System.out.println("хор скорость:  " + horSpeed);
                System.out.println("высота:        " + (ship.getHeights() - r));
                System.out.println("гор расстояние:" + distance);
                System.out.println();
                a++;
                i = 0;
            }

            if(r > ship.getHeights()){
                System.out.println("Crash!!!!");
                break;
            }
        }
    }

    private static void liftOff(Ship ship){


    }

    //метод принимает в виде аргументов массу планеты и высоту от центра планеты
    private static double getAccelerationOfGravity(double m, double r){

        return (G * m) / (r * r);
    }

    private static void gravityModel() {



        double startDistance = 0.01;
        double R = 0.01;

        double speed1 = 0;
        double speed2 = 0;

        double accel1 = 0;
        double accel2 = 0;

        double distance1 = 0;
        double distance2 = 0;

        double mass1 = 100;
        double mass2 = 200;

        int x1 = 0;
        int y1 = 0;

        int x2 = 0;
        int y2 = 1500;

        double F = G * (mass1 * mass2 / (R * R));
        System.out.println(F);

        accel1 = F / mass1;
        accel2 = F / mass2;
        System.out.println(accel1);
        System.out.println(accel2);

        Date date = new Date();
        long startDate = date.getTime();
        System.out.println("start" + startDate);
        for (int i = 0;;) {




            Date Date = new Date();
            long thisDate = Date.getTime();
            //System.out.println(thisDate);

            if (thisDate > startDate) {

                startDate++;

                F = G * (mass1 * mass2 / (R * R));

                //ускорение м/с^2
                accel1 = F / mass1;
                accel2 = F / mass2;

                //скорость м/с
                speed1 = speed1 + (accel1 / 1000);
                speed2 = speed2 + (accel2 / 1000);


                if (R >= 0) {
                    R = R - ((speed1 + speed2) * 0.001);
                }
                else {
                    R = R + ((speed1 + speed2) * 0.001);
                }

                //пройденное расстояние

                if (mass1 == mass2) {

                    distance1 = (startDistance - R) / 2;
                    distance2 = distance1;

                    if (i == 60) {

                        x1++;
                        x2++;



                        System.out.println("accel 1: " + accel1);
                        System.out.println("accel 2: " + accel2);
                        System.out.println("speed 1: " + speed1);
                        System.out.println("speed 2: " + speed2);
                        System.out.println("distance: " + R + "\n");
                        i = 0;
                    }

                }
                else {

                    if (i == 60) {

                        x1++;
                        x2++;



                        System.out.println("accel 1: " + accel1);
                        System.out.println("accel 2: " + accel2);
                        System.out.println("speed 1: " + speed1);
                        System.out.println("speed 2: " + speed2);
                        System.out.println("distance: " + R + "\n");
                        i = 0;
                    }
                }
                i++;
            }
        }
    }
}