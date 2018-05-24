//
//  DetailViewController.swift
//  Groupe1iOS
//
//  Created by Florian ALONSO on 5/16/18.
//  Copyright © 2018 Hetic. All rights reserved.
//

import UIKit

class DetailViewController: UIViewController {

    @IBOutlet weak var myLabel: UILabel!
    @IBOutlet weak var myButton: UIButton!
    @IBOutlet weak var myTableView: UITableView!
    @IBOutlet weak var loadingView: UIView!
    
    var theNewText: String?
    
    lazy var contacts = [Contact]()
    
    override func viewDidLoad() {
        super.viewDidLoad()

        myButton.setTitleColor(UIColor.purple, for: .normal)
        myLabel.text = theNewText
        
        /*
        contacts.append(Contact(firstName: "Yvan", lastName: "Moté", phoneNumber: "+3526661544744"))
        contacts.append(Contact(firstName: "Cédric", lastName: "Coron", phoneNumber: "0677239001"))
        contacts.append(Contact(firstName: "Antoine", lastName: "Dunn", phoneNumber: "0798402133"))
        contacts.append(Contact(firstName: "Octave", lastName: "Luangkhot", phoneNumber: "0634786211"))
        contacts.append(Contact(firstName: "Paul", lastName: "Andrianoff", phoneNumber: "0689100063"))
        contacts.append(Contact(firstName: "Jamy", lastName: "Gourmand", phoneNumber: "2908309830"))
        contacts.append(Contact(firstName: "Justin", lastName: "Case", phoneNumber: "9309389009"))
        contacts.append(Contact(firstName: "Mark", lastName: "Zuk", phoneNumber: "88288288222"))
        contacts.append(Contact(firstName: "Jamy", lastName: "Dutronc", phoneNumber: "908309483"))
        contacts.append(Contact(firstName: "Bérangère", lastName: "Martin", phoneNumber: "0688256031"))
        contacts.append(Contact(firstName: "Lucie", lastName: "Fer", phoneNumber: "666"))
        contacts.append(Contact(firstName: "Peter", lastName: "Gabriel", phoneNumber: "2983098230"))
        */
        
        UserService.fetchUsers(result: { (contacts) in
            
            self.contacts.removeAll()  // Nettoyage du tableau actuel
            self.contacts.append(contentsOf: contacts) // stockage des contacts reçus à partir du JSONS
            
            // Refresh UI
            
            self.myTableView.reloadData()
            
            // On masque la loading view
            self.loadingView.isHidden = true
            
        }) { (error) in
            
            // On masque la loading view
            self.loadingView.isHidden = true
        }

    }
    
    @IBAction func didTapOnButton(_ sender: Any) {
        print("Salut")
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        
        if let identifier = segue.identifier {
            if identifier == ContactDetailViewController.identifier {
                if let contactDetailViewController = segue.destination as? ContactDetailViewController,
                    let indexPath = myTableView.indexPathForSelectedRow {
                    contactDetailViewController.contact = contacts[indexPath.row]
                }
            }
        }        
    }
}

extension DetailViewController: UITableViewDataSource {
    func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        return contacts.count
    }
    
    func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        
        
        // Soit on a une cellule créée ou alors récupérée depuis le cache
        let contactTableViewCell = tableView.dequeueReusableCell(withIdentifier: ContactTableViewCell.identifier, for: indexPath) as! ContactTableViewCell
        
        let contact = self.contacts[indexPath.row]
        
        contactTableViewCell.contact = contact        
        
        return contactTableViewCell
    }
    
    
}















