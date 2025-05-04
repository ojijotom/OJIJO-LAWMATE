package com.ojijo.ojijolawmate.ui.screens.lawdetail

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ojijo.ojijolawmate.ui.screens.viewlaws.Law
import kotlin.collections.listOf

// Sample law data (use your actual data source here)
private val sampleLaws = listOf(
Law("Section 376", "Punishment for Rape", "Whoever commits rape shall be punished with rigorous imprisonment for a term not less than 10 years."),
Law("Section 420", "Cheating", "Cheating and dishonestly inducing delivery of property is punishable with 7 years jail and fine."),
Law("Section 498A", "Cruelty by Husband", "Cruelty by husband or his relatives is punishable with imprisonment up to 3 years."),
Law("Section 203", "Definition of Murder", "Murder is defined as the unlawful killing of another human being with malice aforethought."),
Law("Section 204", "Punishment for Murder", "Any person convicted of murder shall be sentenced to death."),
Law("Section 205", "Attempt to Murder", "Attempting to commit murder is punishable with imprisonment for life."),
Law("Section 206", "Malice Aforethought", "Malice aforethought includes intention to cause death or grievous harm."),
Law("Section 207", "Manslaughter", "Unlawful killing without malice aforethought is considered manslaughter."),
Law("Section 208", "Killing on Provocation", "Killing in the heat of passion caused by sudden provocation is punishable as manslaughter."),
Law("Section 209", "Infanticide", "A woman who causes the death of her child under twelve months due to disturbed mind is guilty of infanticide."),
Law("Section 210", "Killing Unborn Child", "Causing the death of an unborn child is punishable with imprisonment."),
Law("Section 211", "Concealing Birth", "Concealing the birth of a child is an offence punishable by imprisonment."),
Law("Section 212", "Child Destruction", "Intentionally causing the death of a child capable of being born alive is punishable."),
Law("Section 213", "Preventing Child Being Born Alive", "Acts preventing a child from being born alive are punishable."),
Law("Section 214", "Abandoning Child", "Abandoning a child under the age of two years is punishable."),
Law("Section 215", "Exposing Child", "Exposing a child under the age of two years to danger is punishable."),
Law("Section 216", "Neglecting Children", "Neglecting to provide necessities for children is punishable."),
Law("Section 217", "Endangering Life", "Doing an act with intent to endanger life is punishable."),
Law("Section 218", "Grievous Harm", "Causing grievous harm is punishable with imprisonment."),
Law("Section 219", "Attempting Suicide", "Attempting to commit suicide is an offence."),
Law("Section 220", "Aiding Suicide", "Aiding or abetting suicide is punishable."),
Law("Section 221", "Conspiracy to Murder", "Conspiring to commit murder is punishable."),
Law("Section 222", "Accessory After the Fact to Murder", "Assisting a murderer after the fact is punishable."),
Law("Section 223", "Attempt to Murder by Poison", "Attempting to murder by poison is punishable."),
Law("Section 224", "Attempt to Murder by Wounding", "Attempting to murder by wounding is punishable."),
Law("Section 225", "Attempt to Murder by Other Means", "Attempting to murder by other means is punishable."),
Law("Section 226", "Attempt to Murder by Setting Fire", "Attempting to murder by setting fire is punishable."),
Law("Section 227", "Attempt to Murder by Drowning", "Attempting to murder by drowning is punishable."),
Law("Section 228", "Attempt to Murder by Strangulation", "Attempting to murder by strangulation is punishable."),
Law("Section 229", "Attempt to Murder by Shooting", "Attempting to murder by shooting is punishable."),
Law("Section 230", "Attempt to Murder by Blasting", "Attempting to murder by blasting is punishable."),
Law("Section 231", "Attempt to Murder by Other Means", "Attempting to murder by other means is punishable."),
Law("Section 232", "Attempt to Murder by Poisoning", "Attempting to murder by poisoning is punishable."),
Law("Section 233", "Attempt to Murder by Wounding", "Attempting to murder by wounding is punishable."),
Law("Section 234", "Attempt to Murder by Other Means", "Attempting to murder by other means is punishable."),
Law("Section 235", "Attempt to Murder by Setting Fire", "Attempting to murder by setting fire is punishable."),
Law("Section 236", "Attempt to Murder by Drowning", "Attempting to murder by drowning is punishable."),
Law("Section 237", "Attempt to Murder by Strangulation", "Attempting to murder by strangulation is punishable."),
Law("Section 238", "Attempt to Murder by Shooting", "Attempting to murder by shooting is punishable."),
Law("Section 239", "Attempt to Murder by Blasting", "Attempting to murder by blasting is punishable."),
Law("Section 240", "Attempt to Murder by Other Means", "Attempting to murder by other means is punishable."),
Law("Section 241", "Attempt to Murder by Poisoning", "Attempting to murder by poisoning is punishable."),
Law("Section 242", "Attempt to Murder by Wounding", "Attempting to murder by wounding is punishable."),
Law("Section 243", "Attempt to Murder by Other Means", "Attempting to murder by other means is punishable."),
Law("Section 244", "Attempt to Murder by Setting Fire", "Attempting to murder by setting fire is punishable."),
Law("Section 245", "Attempt to Murder by Drowning", "Attempting to murder by drowning is punishable."),
Law("Section 246", "Attempt to Murder by Strangulation", "Attempting to murder by strangulation is punishable."),
Law("Section 247", "Attempt to Murder by Shooting", "Attempting to murder by shooting is punishable."),
Law("Section 248", "Attempt to Murder by Blasting", "Attempting to murder by blasting is punishable."),
Law("Section 249", "Attempt to Murder by Other Means", "Attempting to murder by other means is punishable."),
Law("Section 250", "Attempt to Murder by Poisoning", "Attempting to murder by poisoning is punishable."),
Law("Section 251", "Attempt to Murder by Wounding", "Attempting to murder by wounding is punishable."),
Law("Section 302", "Punishment for Murder", "Whoever commits murder shall be punished with death or imprisonment for life."),
Law("Section 376", "Punishment for Rape", "Whoever commits rape shall be punished with rigorous imprisonment for a term not less than 10 years."),
Law("Section 420", "Cheating", "Cheating and dishonestly inducing delivery of property is punishable with 7 years jail and fine."),
Law("Section 498A", "Cruelty by Husband", "Cruelty by husband or his relatives is punishable with imprisonment up to 3 years."),
Law("Section 268", "Definition of Theft", "A person is guilty of theft if he dishonestly appropriates property belonging to another."),
Law("Section 275", "General Punishment for Theft", "Anyone guilty of theft is liable to imprisonment for three years."),
Law("Section 278", "Theft in Dwelling House", "Stealing in a dwelling-house is punishable by imprisonment up to seven years."),
Law("Section 279", "Theft by Clerk or Servant", "A clerk or servant stealing from their employer is punishable by seven years imprisonment."),
Law("Section 280", "Stealing by Directors or Officers", "Stealing by company directors or officers is punishable by imprisonment."),
Law("Section 281", "Stealing by Agents", "An agent who steals entrusted property is liable to imprisonment."),
Law("Section 286", "Robbery", "Anyone who uses or threatens violence to steal is guilty of robbery."),
Law("Section 296", "Armed Robbery", "If the offender is armed with a dangerous weapon, the offence becomes robbery with violence."),
Law("Section 297", "Attempted Robbery", "Attempting to commit robbery is punishable with up to seven years imprisonment."),
Law("Section 308", "Preparation to Commit a Felony", "Being found armed with intent to commit a felony is punishable."),
Law("Section 316", "Forgery", "Making a false document with intent to defraud is forgery."),
Law("Section 317", "Uttering a False Document", "Using a forged document as genuine is punishable by imprisonment."),
Law("Section 322", "Handling Stolen Goods", "Receiving or retaining stolen goods knowingly is punishable."),
Law("Section 330", "False Pretences", "Obtaining goods or money by false pretences is punishable by imprisonment."),
Law("Section 339", "Arson", "Anyone who willfully sets fire to property is guilty of arson."),
Law("Section 345", "Burglary", "Entering a dwelling at night with intent to commit a felony is burglary."),
Law("Section 346", "Housebreaking", "Breaking and entering a building with intent to steal is housebreaking."),
Law("Section 349", "Criminal Trespass", "Entering into property unlawfully with intent to commit an offence."),
Law("Section 354", "Assault", "Any unlawful attack on a person is an assault."),
Law("Section 357", "Assault Causing Actual Bodily Harm", "Assault causing bodily harm is punishable with up to five years imprisonment."),
Law("Section 362", "Kidnapping", "Taking a person away by force is kidnapping."),
Law("Section 364", "Defilement", "Defiling a child under the age of 18 is a criminal offence."),
Law("Section 366", "Incest", "Sexual relations with a close family member is punishable as incest."),
Law("Section 367", "Indecent Assault", "Committing an indecent act with another person without consent is punishable."),
Law("Section 372", "Procuration", "Procuring a person for defilement or prostitution is punishable."),
Law("Section 375", "Sodomy", "Having carnal knowledge against the order of nature is punishable."),
Law("Section 377", "Bestiality", "Sexual acts with animals are punishable as unnatural offences."),
Law("Section 382", "Public Nuisance", "Causing annoyance to the public is an offence."),
Law("Section 393", "Conspiracy to Commit Offence", "Two or more persons conspiring to commit a crime is punishable."),
Law("Section 400", "Perjury", "Knowingly giving false testimony under oath is punishable by imprisonment."),
Law("Section 407", "Escape from Lawful Custody", "Escaping from lawful custody is an offence punishable by imprisonment."),
Law("Section 409", "Resisting Arrest", "Resisting or obstructing a lawful arrest is punishable."),
Law("Section 416", "Bribery of Public Officials", "Offering or accepting a bribe is punishable."),
Law("Section 419", "Fraudulent Deeds and Dispositions", "Creating false deeds to defraud is punishable."),
Law("Section 421", "Obscene Publications", "Distribution of obscene material is punishable."),
Law("Section 423", "Insulting Modesty of Women", "Insulting or offending the modesty of a woman is punishable."),
Law("Section 426", "Idle and Disorderly Persons", "Being idle and disorderly in public is a punishable offence."),
Law("Section 428", "Drunkenness and Disorder", "Being drunk and disorderly in public is punishable by fine or imprisonment."),
Law("Section 430", "Rogue and Vagabond", "Living without visible means of livelihood is punishable."),
Law("Section 431", "Habitual Criminals", "Repeat offenders may be deemed habitual criminals and sentenced accordingly."),
Law("Section 435", "Contempt of Court", "Disobedience or insult to a court is punishable."),
Law("Section 440", "Offences Relating to Religion", "Acts intended to insult religion or disturb worship are punishable."),
Law("Section 441", "Affray", "Two or more persons fighting in a public place, disturbing the peace, are guilty of affray."),
Law("Section 444", "Criminal Damage", "Anyone who intentionally or recklessly destroys or damages property belonging to another is guilty."),
Law("Section 447", "Attempt to Commit a Misdemeanor", "A person attempting to commit a misdemeanor is punishable as if the offense were committed."),
Law("Section 451", "Making Explosives", "Making or possessing explosives with intent to commit a crime is punishable."),
Law("Section 454", "Demanding Property with Menace", "Demanding money or property with threats is punishable."),
Law("Section 459", "Dealing in Trophies Without License", "Possessing wildlife trophies without a license is punishable."),
Law("Section 463", "Malicious Damage by Fire", "Setting fire to crops, buildings, or property with malicious intent is a criminal offense."),
Law("Section 470", "Forgery of Stamps", "Forgery of revenue stamps or postal stamps is punishable."),
Law("Section 476", "Counterfeiting Currency", "Making or using counterfeit money is a felony."),
Law("Section 481", "Possession of Forged Currency", "Having forged currency in one's possession knowingly is punishable."),
Law("Section 488", "False Swearing", "Making a false statement under oath not in judicial proceedings is an offense."),
Law("Section 491", "Personation of Public Officers", "Pretending to be a public officer or assuming a false character is punishable."),
Law("Section 496", "False Accusation", "Accusing someone falsely of a crime knowing it to be untrue is an offense."),
Law("Section 499", "Obstruction of Justice", "Obstructing or interfering with the process of justice is punishable."),
Law("Section 501", "Escape from Custody", "Any escape or attempt to escape from lawful custody is a punishable offense."),
Law("Section 503", "Neglect to Prevent Felony", "Failing to prevent a felony when legally bound to do so is an offense."),
Law("Section 507", "Preventing Service of Summons", "Willfully preventing the delivery of court summons is punishable."),
Law("Section 510", "False Statements to Public Officers", "Giving false information to public officers is an offense."),
Law("Section 513", "Possession of Instruments for Forgery", "Having materials used for forgery is a punishable offense."),
Law("Section 517", "Offences Against Morality", "Acts that grossly offend public decency are punishable."),
Law("Section 520", "Unnatural Offences", "Carnal knowledge of persons or animals against the order of nature is punishable."),
Law("Section 525", "Traffic of Minors", "Trafficking minors for sexual exploitation or labor is a serious offense."),
Law("Section 529", "Publication of False News", "Publishing false information that may cause public alarm is a crime."),
Law("Section 532", "Unlawful Assembly", "Three or more persons assembling with intent to commit an unlawful act is an offense."),
Law("Section 535", "Rioting After Proclamation", "Continuing to riot after being ordered to disperse is punishable."),
Law("Section 537", "Possession of Offensive Weapons", "Carrying offensive weapons in public without lawful excuse is an offense."),
Law("Section 540", "Participating in Organized Crime", "Engaging in or supporting a criminal organization is punishable."),
Law("Section 543", "Violation of Election Laws", "Tampering with election processes is an offense under electoral laws."),
Law("Section 550", "Harboring Criminals", "Knowingly harboring or helping a criminal to evade justice is punishable."),
Law("Section 555", "Cyber Crime", "Unauthorized access, data interference, and system interference using computers is punishable under the Cybercrimes Act."),
Law("Section 560", "Human Trafficking", "Recruiting, transporting, or harboring persons for exploitation is a punishable offense."),
Law("Section 565", "Child Pornography", "Creating, distributing, or possessing child pornography is a serious offense."),
Law("Section 570", "Corruption and Economic Crimes", "Accepting, giving, or soliciting bribes is punishable under anti-corruption laws."),
Law("Section 575", "Tax Evasion", "Deliberately underreporting income or falsifying tax returns is a criminal offense."),
Law("Section 580", "Impersonation on Digital Platforms", "Falsely assuming another's identity on social media or online platforms is punishable."),
Law("Section 585", "Cyber Harassment", "Using digital communication to harass, threaten, or bully others is a punishable offense."),
Law("Section 302", "Punishment for Murder", "Whoever commits murder shall be punished with death or imprisonment for life."),
Law("Section 376", "Punishment for Rape", "Whoever commits rape shall be punished with rigorous imprisonment for a term not less than 10 years."),
Law("Section 420", "Cheating", "Cheating and dishonestly inducing delivery of property is punishable with 7 years jail and fine."),
Law("Section 498A", "Cruelty by Husband", "Cruelty by husband or his relatives is punishable with imprisonment up to 3 years."),
Law("Section 120B", "Criminal Conspiracy", "Party to a criminal conspiracy shall be punished with the punishment provided for the offense."),
Law("Section 124A", "Sedition", "Attempting to excite disaffection toward the government shall be punished with life imprisonment."),
Law("Section 295", "Defiling Place of Worship", "Injuring or defiling a place of worship with intent to insult religion is punishable with 2 years imprisonment."),
Law("Section 326", "Grievous Hurt by Dangerous Weapons", "Causing grievous hurt by dangerous weapons is punishable up to 10 years or life imprisonment."),
Law("Section 341", "Wrongful Restraint", "Punishable with imprisonment up to 1 month or fine."),
Law("Section 354", "Outraging Modesty of Woman", "Assault or criminal force on woman intending to outrage her modesty is punishable with 1-5 years imprisonment."),
Law("Section 377", "Unnatural Offences", "Voluntarily having carnal intercourse against the order of nature is punishable up to 10 years or life imprisonment."),
Law("Section 379", "Theft", "Punishable with imprisonment up to 3 years or fine or both."),
Law("Section 392", "Robbery", "Punishable with rigorous imprisonment up to 10 years and fine."),
Law("Section 397", "Robbery with Attempt to Cause Death", "Punishable with rigorous imprisonment not less than 7 years."),
Law("Section 403", "Dishonest Misappropriation", "Punishable with imprisonment up to 2 years or fine or both."),
Law("Section 409", "Criminal Breach of Trust", "By public servant is punishable with life imprisonment or up to 10 years and fine."),
Law("Section 447", "Criminal Trespass", "Punishable with imprisonment up to 3 months or fine."),
Law("Section 506", "Criminal Intimidation", "Punishable with imprisonment up to 2 years or fine or both."),
Law("Section 509", "Insulting Modesty of Woman", "Words or gestures intended to insult modesty of a woman is punishable with 1 year imprisonment or fine."),
Law("Section 511", "Attempting to Commit Offenses", "Punishable according to the gravity of the offense attempted."),
Law("Section 143", "Unlawful Assembly", "Member of an unlawful assembly is punishable with imprisonment up to 6 months or fine or both."),
Law("Section 147", "Rioting", "Punishable with imprisonment up to 2 years or fine or both."),
Law("Section 148", "Rioting with Deadly Weapon", "Punishable with imprisonment up to 3 years or fine or both."),
Law("Section 153A", "Promoting Enmity Between Groups", "Promoting enmity on grounds of religion, race, etc., is punishable with up to 3 years imprisonment."),
Law("Section 201", "Causing Disappearance of Evidence", "Punishable with up to 7 years imprisonment and fine."),
Law("Section 212", "Harbouring Offender", "Harbouring an offender is punishable with imprisonment depending on offense."),
Law("Section 216", "Harbouring Escaped Convict", "Punishable with imprisonment up to 3 years or fine or both."),
Law("Section 268", "Public Nuisance", "An act causing injury, danger or annoyance to public is punishable."),
Law("Section 269", "Negligent Act Likely to Spread Infection", "Punishable with imprisonment up to 6 months or fine."),
Law("Section 270", "Malignant Act to Spread Infection", "Punishable with imprisonment up to 2 years or fine."),
Law("Section 278", "Making Atmosphere Noxious", "Punishable with fine up to 500 rupees."),
Law("Section 285", "Negligent Conduct with Fire", "Punishable with imprisonment up to 6 months or fine."),
Law("Section 290", "Punishment for Public Nuisance", "Punishable with fine up to 200 rupees."),
Law("Section 295A", "Deliberate Insult to Religion", "Punishable with imprisonment up to 3 years or fine or both."),
Law("Section 298", "Uttering Words to Hurt Religious Feelings", "Punishable with imprisonment up to 1 year or fine."),
Law("Section 304A", "Causing Death by Negligence", "Punishable with imprisonment up to 2 years or fine or both."),
Law("Section 306", "Abetment of Suicide", "Punishable with imprisonment up to 10 years and fine."),
Law("Section 312", "Causing Miscarriage", "Punishable with up to 3 years imprisonment and fine."),
Law("Section 313", "Miscarriage Without Woman’s Consent", "Punishable with life imprisonment or up to 10 years."),
Law("Section 323", "Voluntarily Causing Hurt", "Punishable with imprisonment up to 1 year or fine or both."),
Law("Section 324", "Causing Hurt with Dangerous Weapon", "Punishable with up to 3 years imprisonment and fine."),
Law("Section 325", "Voluntarily Causing Grievous Hurt", "Punishable with imprisonment up to 7 years and fine."),
Law("Section 332", "Voluntarily Causing Hurt to Deter Public Servant", "Punishable with up to 3 years imprisonment or fine or both."),
Law("Section 333", "Grievous Hurt to Deter Public Servant", "Punishable with imprisonment up to 10 years and fine."),
Law("Section 341", "Wrongful Restraint", "Punishable with simple imprisonment up to 1 month or fine or both."),
Law("Section 354A", "Sexual Harassment", "Punishable with imprisonment up to 3 years or fine."),
Law("Section 375", "Definition of Rape", "Defines rape including various conditions under which consent is invalid."),
Law("Section 377", "Unnatural Offenses", "Punishable with imprisonment for life or up to 10 years and fine.")

)



@Composable
fun LawDetailScreen(section: String) {
    val law = getLawBySection(section)

    if (law != null) {
        LawDetailContent(law)
    } else {
        LawNotFoundContent()
    }
}

@Composable
private fun LawDetailContent(law: Law) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = law.section,
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = law.title,
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = law.description,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
private fun LawNotFoundContent() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.Center) {
        Text(
            text = "Law not found",
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

private fun getLawBySection(section: String): Law? {
    return sampleLaws.find { it.section == section }
}
