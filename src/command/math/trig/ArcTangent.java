/**
 *
 */
package command.math.trig;

/**
 *
 * @author Sally Al
 *
 */
public class ArcTangent extends Trig {
    public ArcTangent () {
        super();
    }

    @Override
    protected double evaluateAngle (double angle) {
        return (Math.atan(angle));
    }

}
