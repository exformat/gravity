public class Ship{

    private double mass = 0;
    private double fuelMass = 0;
    private double powerTrust = 0;
    private double fuelOut = 0;
    private double accel = 0;
    private double speed = 0;
    private double heights = 0;

    public void setHeights(double heights)
    {
        this.heights = heights;
    }

    public double getHeights()
    {
        return heights;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    public double getSpeed()
    {
        return speed;
    }

    public void setAccel(double accel)
    {
        this.accel = accel;
    }

    public double getAccel()
    {

        return this.accel;
    }

    public void setFuelOut(double fuelOut)
    {
        this.fuelOut = fuelOut;
    }

    public double getFuelOut()
    {
        return fuelOut;
    }

    public void setPowerTrust(double powerTrust)
    {
        this.powerTrust = powerTrust;
    }

    public double getPowerTrust()
    {

        return powerTrust;
    }

    public void setFuelMass(double fuelMass)
    {
        this.fuelMass = fuelMass;
    }

    public double getFuelMass()
    {
        return fuelMass;
    }

    public void setMass(double mass)
    {
        this.mass = mass;
    }

    public double getMass()
    {
        return mass;
    }
}