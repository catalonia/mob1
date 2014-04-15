//
//  ShowMapVC.m
//  TasteSync
//
//  Created by HP on 3/11/14.
//  Copyright (c) 2014 TasteSync. All rights reserved.
//

#import "ShowMapVC.h"
#import <MapKit/MapKit.h>
#import <CoreLocation/CoreLocation.h>
#import "AddressAnnotation.h"

@interface ShowMapVC ()<MKMapViewDelegate>
{
    __weak IBOutlet MKMapView *mapView;
    CLLocationCoordinate2D coordRestaurant;
    RestaurantObj* _restaurantObj;
    BOOL isHideTabbar;
}
@end

@implementation ShowMapVC

- (id)initWithNibName:(NSString *)nibNameOrNil bundle:(NSBundle *)nibBundleOrNil
{
    self = [super initWithNibName:nibNameOrNil bundle:nibBundleOrNil];
    if (self) {
        // Custom initialization
    }
    return self;
}

- (id)initWithRestaurant:(RestaurantObj*)restaurantObj
{
    self = [super initWithNibName:@"ShowMapVC" bundle:nil];
    if (self) {
        _restaurantObj = restaurantObj;
    }
    return self;
}


- (void)viewDidLoad
{
    [super viewDidLoad];
    
    CLLocationCoordinate2D coordi = CLLocationCoordinate2DMake(_restaurantObj.lattitude, _restaurantObj.longtitude);
    coordRestaurant = coordi;
    AddressAnnotation *restaurantPlace = [[AddressAnnotation alloc] initWithName:_restaurantObj.name details:_restaurantObj.name coordinate:coordi];
    [self displayLocation:restaurantPlace];
    
    
    UITapGestureRecognizer *tap = [[UITapGestureRecognizer alloc] initWithTarget:self action:@selector(imageTapped:)];
    tap.numberOfTapsRequired = 1;
    tap.cancelsTouchesInView=YES;
    mapView.userInteractionEnabled = YES;
    [mapView addGestureRecognizer:tap];
    
}

-(void)imageTapped:(UITapGestureRecognizer *)gesture
{
    NSLog(@"safasdf");
//    if (isHideTabbar == YES) {
//        isHideTabbar = NO;
//        double delayInSeconds = 0.1;
//        dispatch_time_t popTimer = dispatch_time(DISPATCH_TIME_NOW, delayInSeconds*NSEC_PER_SEC);
//        dispatch_after(popTimer, dispatch_get_main_queue(), ^(void){
//            [UIView animateWithDuration:0.5 animations:^{
//                self.navigationController.navigationBar.alpha = 0.0f;
//            }];
//        });
//    }
//    else
//    {
//        isHideTabbar = YES;
//        double delayInSeconds = 0.1;
//        dispatch_time_t popTimer = dispatch_time(DISPATCH_TIME_NOW, delayInSeconds*NSEC_PER_SEC);
//        dispatch_after(popTimer, dispatch_get_main_queue(), ^(void){
//            [UIView animateWithDuration:0.5 animations:^{
//                self.navigationController.navigationBar.alpha = 1.0f;
//            }];
//        });
//    }
}

-(IBAction)backAction:(id)sender
{
    [self.navigationController popViewControllerAnimated:YES];
}

- (void)didReceiveMemoryWarning
{
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

-(void) displayLocation : (AddressAnnotation *) addAnnotation
{
    
    MKCoordinateRegion region;
    MKCoordinateSpan span;
    span.latitudeDelta = 0.005;
    span.longitudeDelta = 0.005;
    
    region.span = span;
    region.center = addAnnotation.coordinate;
    
    [mapView addAnnotation:addAnnotation];
    [mapView setRegion:region];
    [mapView regionThatFits:region];
}

-(void)mapView:(MKMapView *)mapView didSelectAnnotationView:(MKAnnotationView *)view{
    
}

- (MKAnnotationView *) mapView:(MKMapView *)mapView viewForAnnotation:(id<MKAnnotation>)annotation {
    
    static NSString* AnnotationIdentifier = @"AnnotationIdentifier";
    
    MKPinAnnotationView* customPinView = [[MKPinAnnotationView alloc]
                                          initWithAnnotation:annotation reuseIdentifier:AnnotationIdentifier];
    customPinView.pinColor = MKPinAnnotationColorRed;
    customPinView.animatesDrop = YES;
    customPinView.canShowCallout = YES;
    
    UIButton* rightButton = [UIButton buttonWithType:UIButtonTypeDetailDisclosure];
    [rightButton addTarget:self
                    action:@selector(showDetails:)
          forControlEvents:UIControlEventTouchUpInside];
    customPinView.rightCalloutAccessoryView = rightButton;
    
    UIImageView *memorialIcon = [[UIImageView alloc] initWithImage:[CommonHelpers getImageFromName:@"googlemaps_pin.png"]];
    customPinView.leftCalloutAccessoryView = memorialIcon;
    
    return customPinView;
    
    
}

-(IBAction)showDetails:(id)sender
{
    Class mapItemClass = [MKMapItem class];
    if (mapItemClass && [mapItemClass respondsToSelector:@selector(openMapsWithItems:launchOptions:)])
    {
        CLLocationCoordinate2D coordinate =
        CLLocationCoordinate2DMake(coordRestaurant.latitude, coordRestaurant.longitude);
        MKPlacemark *placemark = [[MKPlacemark alloc] initWithCoordinate:coordinate
                                                       addressDictionary:nil];
        MKMapItem *mapItem = [[MKMapItem alloc] initWithPlacemark:placemark];
        [mapItem setName:_restaurantObj.name];
        [mapItem openInMapsWithLaunchOptions:nil];
    }
}


@end
