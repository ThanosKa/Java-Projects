package JThreads;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class BHTree {
    
    private  static final double THETA =  0.5;
    private Planet planet;
    private Quad quad;
    private BHTree NW;
    private BHTree NE;
    private BHTree SW;
    private BHTree SE;
  
    
    /** Constructor
     * creates a new BH tree with no planets
     * @param quad
     */
    public BHTree(Quad q) {
         this.quad = q;
         this.planet = null;

         this.NW=null;
         this.NE=null;
         this.SW=null;
         this.SE=null;
    }
    
     /**
     * adds the planet to the tree 
     * @param pl
     */
    public void insert(Planet pl){
        //if there is no planet,  insert the planet.
        if(planet == null) {
            planet = pl;
            return ;
        }
        //if planet exists but its not external
        // combine the two planets and find at which quadrant
        // of the tree is hould be located in. (recursively)
        if(isExternal()==false) 
        {
            
            planet = planet.plus(pl);
            //rec insert planet pl into  quadrant
            putPlanet(pl);


        }
        
        /*
		 * If the node is external we create the sub nodes representing each sub
		 * quadrant 
		 */
        else {
            NW = new BHTree(quad.NW());
            NE = new BHTree(quad.NE());
            SE = new BHTree(quad.SE());
            SW = new BHTree(quad.SW());

            putPlanet(planet);
            putPlanet(pl);

            planet = planet.plus(pl);

        }
    }
    
     /**
     *  inserts a body into quadrant 
     * @param pl
     */
    private void putPlanet(Planet pl)
    {
        if (pl.inQuad(quad.NW())){
            NW.insert(pl);
            return;
        }
        else if (pl.inQuad(quad.NE())){
            NE.insert(pl);
            return;
        }
        else if (pl.inQuad(quad.SW())){
            SW.insert(pl);
            return;
        }

        else if (pl.inQuad(quad.SE())){
            SE.insert(pl);
            return;
        }
            
    }
    
    private boolean isExternal()
    {
        if(NW == null && NE == null && SW == null && SW == null)
            return  true;
        else return  false;
    }
    
    /**
     * calculates force on Planet pl  from all planets  
     * in the BH Tree and updates it
     * @param pl
     */
    
    public void updateForce(Planet pl)
    {
        if(planet == null) return ;
        if(pl.equals(planet)) return;

        //if curr is external .update 
        if(isExternal())
        {
            
            pl.addForce(planet);
        }
        //internal  nodes
        else {
            double s;
            double d;
            //width
            s = quad.length();
            //distanceTo == distance
            //distance between pl and node's center mass 
            d=planet.distance(pl);

            // s/d threashold value for theta 
            if((s/d)< THETA)
                pl.addForce(planet);
            //recurse   on each node's children
            else {
                NW.updateForce(pl);
                NE.updateForce(pl);
                SW.updateForce(pl);
                SE.updateForce(pl);
            }
        }

    }
    
}
