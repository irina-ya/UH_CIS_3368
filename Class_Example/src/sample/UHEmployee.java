package sample;

public class UHEmployee implements Employee
{
    public String name;
    public int id;
    private boolean isActive;

    @Override
    public void hire()
    {
        isActive = true;
    }

    @Override
    public void fire()
    {
        isActive = false;
    }
}
