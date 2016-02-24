package edu.byu.cs.superasteroids.database;

import edu.byu.cs.superasteroids.model.Projectile;

/** DAO to access Projectile Objects from the DB
 *
 */
public class ProjectileDao {
    /** Gets all Projectile objects from the DB
     *
     * @return Array of all BG objects in the DB
     */
    public Projectile[] getAll(){
        Projectile[] allBG = new Projectile[]{};
        return allBG;
    }

    /** Gets a single Projectile from the DB 
     *
     * @param id ID for the desired Projectile object
     * @return Single Projectile object
     */
    public Projectile get(int id){
        Projectile bg = new Projectile();
        return bg;
    }

    /** Inserts an Projectile into the DB
     *
     *  @param roid Projectile to add
     */
    public void insert(Projectile roid){

    }
}
