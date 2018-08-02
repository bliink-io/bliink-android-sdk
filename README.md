# BLIINK Android SDK

## Sample Quick Start

### Download our sample app

Download ou sample app from our github repository
```
git clone https://github.com/bliink-io/bliink-android-sdk.git
```

### Run the sample app

Run the project by clicking on run button in Android Studio or Maj + F10

## Installation

### Dependencies
Add the SDK to your **build.gradle**
```
implementation 'io.bliink:bliink-android-sdk:1.0.2'
```
And add the dependencies
```
implementation 'com.squareup.okhttp3:okhttp:3.10.0'
implementation 'com.squareup.retrofit2:retrofit:2.4.0'
implementation 'com.squareup.retrofit2:converter-gson:2.4.0'
implementation 'com.squareup.okhttp3:logging-interceptor:3.10.0'
```
### Import

Import the library in your **MainActivity** and in your other files who will show the in-image ad
```
import BLIINKInImageView;
import BLIINKAdContent;
```

## Load an ad

### Initialize the Sdk
In your **launcher activity** you need to create an instance of **BLIINK SDK**
```
BLIINK.getInstance().initialize(this, [YOUR_NETWORK_ID], [YOUR_SITE_ID], true, 5);
```
**Parameters:**
- **this * _(Context)_:** The context of the application.
- **[YOUR_NETWORK_ID] * _(Integer)_:** It's your network id.
- **[YOUR_SITE_ID] * _(Integer)_:** It's your site id.
- **true _(Boolean)_:** It's to authorize or not the location. It's an optional parameter and it is set to false by default.
- **5 _(Integer)_:** It's the timeout that will be used to request the ad. This is an optional parameter, the default value is set to 5 and the unit is in seconds.

> parameters with * are mandatory

### Create the BLIINKInImageView in your xml file
In your **layout xml** file
You have to instantiate the adView in the same layout as the image, so it will automatically take the same size :
```
<RelativeLayout
        android:id="@+id/imageWebviewLayout"
        android:layout_width="match_parent"
        android:layout_margin="20dp"
        app:layout_constraintTop_toBottomOf="@id/text2"
        android:layout_height="wrap_content">

        //Your Image
        <ImageView
            android:id="@+id/imageView"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:src="@drawable/imgage"
            android:adjustViewBounds="true"/>

        //The adView
        <BLIINKInImageView
            android:id="@+id/ui_home_ad_view"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_alignBottom="@id/imageView" />
</RelativeLayout>
```

### Instanciate the ImageView
Create an instance of **BLIINKInImageView** and link it with the view in your
```
BLIINKInImageView mBliinkInImageView = findViewById(R.id.BLIINKUiAdview);
```

### Call to load the ad
In a simple **activity** call the function **loadAd** with your tag ID, an hashmap with your parameters and a BLIINKInImageView.AdResponseHandler listener
```
//Listener
BLIINKInImageView.AdResponseHandler mBliinkInImageListener = new BLIINKInImageView.AdResponseHandler() {
            @Override
            public void adLoadingCompleted(BLIINKAdContent adContent) {
                BLIINKUtils.v(TAG, "adLoadingCompleted");
            }

            @Override
            public void adLoadingFailed(Exception e) {
                BLIINKUtils.v(TAG, "adLoadingFailed");
            }
        };

//HashMap with your parameters
HashMap<String, String> options = new HashMap<String, String>();
options.put("pageTitle", "Coupe du monde 2018");
options.put("pageDescription", "Le bus des Bleus sur les Champs-Elysees");
options.put("keywords", "bliink, foot, coupe du monde");
options.put("imageUrl", "https://bliink.io/img/pictures/pic--tablet.png");
options.put("pageUrl", "https://bliink.io/technology");
options.put("tags", "bliink, foot, coupe du monde");

//Call to load the new ad
mBliinkInImageView.loadAd(tagId, options, mBliinkInImageListener);
```
The **options** HashMap is used to contextualize your article, it contains :
- **pageTitle _(String)_:** Title of the page
- **pageDescription _(String)_:** Description of the page
- **keywords _(String)_:** Keywords for the targeting
- **imageUrl _(String)_:** Url of the image
- **pageUrl _(String)_:** Url of the page
- **tags _(String)_:** Tags for the targeting

## Permissions
### Location
To be able to get the user location you have to add in your **AndroidManifest.xml** :
```
<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION" />
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
```

### Network Informations
To be able to get the user network informations you have to add in your **AndroidManifest.xml** :
```
<uses-permission android:name="android.permission.INTERNET" />
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```
