package fr.poslovitch.em4j;

public class Interval<T extends Number>{
    
    public enum BoundRule{
        INCLUSIVE,
        EXCLUSIVE;
    }
    
    private BoundRule minimumRule;
    private BoundRule maximumRule;
    
    private T minimum;
    private T maximum;
    
    public Interval(T minimum, T maximum) throws IllegalArgumentException{
        this(minimum, BoundRule.INCLUSIVE, maximum, BoundRule.EXCLUSIVE);
    }
    
    public Interval(T minimum, BoundRule minimumRule, T maximum, BoundRule maximumRule) throws IllegalArgumentException{
        
    }
    
    public T getMinimum(){
        return minimum;
    }
    
    public T getMaximum(){
        return maximum;
    }
    
    public double min(){
        return minimum.doubleValue();
    }
    
    public double max(){
        return maximum.doubleValue();
    }
    
    public double range(){
        return max() - min();
    }
    
    public BoundRule getMinimumRule(){
        return minimumRule;
    }
    
    public BoundRule getMaximumRule(){
        return maximumRule;
    }
    
    public boolean contains(Number number) throws IllegalArgumentException{
        if(number == null) throw new IllegalArgumentException("Value cannot be null");
        
        boolean min = (minimumRule == BoundRule.INCLUSIVE) ? (number.doubleValue() >= min()) : (number.doubleValue() > min());
        boolean max = (maximumRule == BoundRule.INCLUSIVE) ? (number.doubleValue() <= max()) : (number.doubleValue() < max());
        return min && max;
    }
    
    @Override
    public String toString(){
        return (minimumRule == BoundRule.INCLUSIVE ? "[" : "]") + minimum + ";" + maximum + (maximumRule == BoundRule.INCLUSIVE ? "]" : "[");
    }
}
